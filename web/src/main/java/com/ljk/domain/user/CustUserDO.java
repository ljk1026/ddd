package com.ljk.domain.user;

import com.ljk.domain.BaseDO;
import com.ljk.domain.user.valueObject.AddressDO;
import lombok.Data;

/**
 * @author liujiankun
 * @date 2020/4/30 17:03
 */
@Data
public class CustUserDO extends BaseDO {

    private Long id;
    /**
     * 客户编码
     */
    private String custCode;
    /**
     * 客户名称
     */
    private String custName;
    /**
     * 租户id
     */
    private Integer tid;
    /**
     * 经营单位id
     */
    private Long operUnitId;
    /**
     * 邮箱:值对象
     */
    private String custEmail;
    /**
     * 地址:值对象
     */
    private AddressDO addressDO;

    public CustUserDO(Long id) {
        this.id = id;
    }

    /**
     * 新建客户
     * @param id
     * @param custCode
     * @param custName
     * @param tid
     * @param operUnitId
     * @param custEmail
     * @param addressDO
     * @return
     */
    public static CustUserDO newCustUserDO(Long id, String custCode, String custName, Integer tid, Long operUnitId, String custEmail, AddressDO addressDO){
        CustUserDO custUserDO = new CustUserDO(id);
        custUserDO.custCode = custCode;
        custUserDO.custName = custName;
        custUserDO.tid = tid;
        custUserDO.operUnitId = operUnitId;
        custUserDO.custEmail = custEmail;
        custUserDO.addressDO = addressDO;
        return custUserDO;
    }


    /**
     * 逻辑删除数据
     */
    public void delUser(){
        this.valid = false;
    }
}
