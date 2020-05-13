package com.ljk.application.user.query.vo;

import lombok.Data;

/**
 * @author liujiankun
 * @date 2020/4/30 19:53
 */
@Data
public class CustUserVO {

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
     * 国家
     */
    private String country;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区县
     */
    private String area;
    /**
     * 详细地址
     */
    private String detailAddr;
}
