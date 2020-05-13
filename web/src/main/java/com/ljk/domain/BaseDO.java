package com.ljk.domain;

import java.time.LocalDateTime;

/**
 * @author liujiankun
 * @date 2020/4/30 17:16
 */
public class BaseDO {
    protected Boolean valid;
    protected LocalDateTime createTime;
    protected String createUserId;
    protected String createUserName;
    protected LocalDateTime updateTime;
    protected String updateUserId;
    protected String updateUserName;
}
