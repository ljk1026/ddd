package com.ljk.domain.user.valueObject;

import lombok.Data;

/**
 * @author liujiankun
 * @date 2020/4/30 17:03
 */
@Data
public  class AddressDO {

    private String country;

    private String province;
    private String city;
    private String area;
    private String detailAddr;
}
