package com.ljk.application.user.command.cmd;

import lombok.Data;

/**
 * @author liujiankun
 * @date 2020/4/30 17:24
 */
@Data
public class CustUserAddCommand {
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
