package com.ljk.infrastructure.user.po;

import com.ljk.infrastructure.BasePo;
import lombok.Data;

import javax.persistence.*;


/**
 * @author liujiankun
 * @date 2020/4/30 16:30
 */
@Entity
@Table(name = "cust_user")
@Data
public class CustUserPO extends BasePo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
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
     * 邮箱
     */
    private String custEmail;
    /**
     * 地址
     */
    private String country;

    private String province;
    private String city;
    private String area;
    private String detailAddr;
}
