package com.ljk.application.user.query;

import com.ljk.application.user.query.vo.CustUserVO;
/**
 * @author liujiankun
 * @date 2020/4/30 19:53
 */
public interface CustUserQuery {
    CustUserVO find(Long id);
}
