package com.ljk.application.user.query.impl;


import com.ljk.application.user.query.CustUserQuery;
import com.ljk.application.user.query.vo.CustUserVO;
import com.ljk.infrastructure.user.dao.CustUserDao;
import com.ljk.infrastructure.user.po.CustUserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author liujiankun
 * @date 2020/4/30 19:53
 */
@Service
@Slf4j
public class CustUserQueryImpl implements CustUserQuery {

    @Autowired
    private CustUserDao custUserDao;

    @Override
   public CustUserVO find(Long id){
        log.info("查询客户信息:{}",id);
       Optional<CustUserPO> optional = custUserDao.findById(id);
       CustUserPO custUserPO = optional.get();
       CustUserVO dto = new CustUserVO();
       BeanUtils.copyProperties(custUserPO,dto);
       return dto;
   }

}
