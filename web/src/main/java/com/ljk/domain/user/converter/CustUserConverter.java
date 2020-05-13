package com.ljk.domain.user.converter;

import com.ljk.domain.user.CustUserDO;
import com.ljk.domain.user.valueObject.AddressDO;
import com.ljk.infrastructure.user.po.CustUserPO;

/**
 * @author liujiankun
 * @date 2020/4/30 17:07
 */
public class CustUserConverter {

    public static CustUserPO serialize(CustUserDO custUserDO){
        CustUserPO target = new CustUserPO();
        target.setId(custUserDO.getId());
        target.setCustCode(custUserDO.getCustCode());
        target.setCustName(custUserDO.getCustName());
        target.setTid(custUserDO.getTid());
        target.setOperUnitId(custUserDO.getOperUnitId());
        target.setCustEmail(custUserDO.getCustEmail());

        AddressDO addressDO = custUserDO.getAddressDO();
        target.setCountry(addressDO.getCountry());
        target.setProvince(addressDO.getProvince());
        target.setCity(addressDO.getCity());
        target.setArea(addressDO.getArea());
        target.setDetailAddr(addressDO.getDetailAddr());

        return target;
    }


    public static CustUserDO deSerialize(CustUserPO custUserPO){
        CustUserDO target = new CustUserDO(custUserPO.getId());
        target.setCustCode(custUserPO.getCustCode());
        target.setCustName(custUserPO.getCustName());
        target.setTid(custUserPO.getTid());
        target.setOperUnitId(custUserPO.getOperUnitId());
        target.setCustEmail(custUserPO.getCustEmail());

        AddressDO addressDO = new AddressDO();
        addressDO.setCountry(custUserPO.getCountry());
        addressDO.setProvince(custUserPO.getProvince());
        addressDO.setCity(custUserPO.getCity());
        addressDO.setArea(custUserPO.getArea());
        addressDO.setDetailAddr(custUserPO.getDetailAddr());
        target.setAddressDO(addressDO);
        return target;
    }

}
