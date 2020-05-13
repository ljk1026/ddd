package com.ljk.application.user.command.impl;

import com.alibaba.fastjson.JSON;
import com.ljk.application.user.command.CustUserService;
import com.ljk.application.user.command.cmd.CustUserAddCommand;
import com.ljk.application.user.command.cmd.CustUserDeleteCommand;
import com.ljk.domain.user.CustUserDO;
import com.ljk.domain.user.converter.CustUserConverter;
import com.ljk.domain.user.valueObject.AddressDO;
import com.ljk.infrastructure.user.dao.CustUserDao;
import com.ljk.infrastructure.user.po.CustUserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author liujiankun
 * @date 2020/4/30 17:28
 */
@Service
@Slf4j
public class CustUserServiceImpl implements CustUserService {

    @Autowired
    private CustUserDao custUserDao;

    @Transactional
    @Override
    public void add(CustUserAddCommand addCommand) {
        log.info("新增客户:{}", JSON.toJSONString(addCommand));
        Long id = System.currentTimeMillis();
        AddressDO addressDO = new AddressDO();
        addressDO.setCountry(addCommand.getCountry());
        addressDO.setProvince(addCommand.getProvince());
        addressDO.setCity(addCommand.getCity());
        addressDO.setArea(addCommand.getArea());
        addressDO.setDetailAddr(addCommand.getDetailAddr());
        //调用领域新增
        CustUserDO custUserDO = CustUserDO.newCustUserDO(id,addCommand.getCustCode(),addCommand.getCustName(),addCommand.getTid(),
                addCommand.getOperUnitId(),addCommand.getCustEmail(),addressDO);
        //转为PO
        CustUserPO custUserPO = CustUserConverter.serialize(custUserDO);
        //持久化
        custUserDao.save(custUserPO);

    }

    @Override
    public void delete(CustUserDeleteCommand deleteCommand) {
        log.info("逻辑删除客户:{}", JSON.toJSONString(deleteCommand));
        Optional<CustUserPO> optional = custUserDao.findById(deleteCommand.getId());
        CustUserPO custUserPO = optional.get();
        CustUserDO custUserDO = CustUserConverter.deSerialize(custUserPO);
        //执行删除逻辑
        custUserDO.delUser();
        //转为PO
        custUserPO = CustUserConverter.serialize(custUserDO);
        //持久化
        custUserDao.save(custUserPO);

    }
}
