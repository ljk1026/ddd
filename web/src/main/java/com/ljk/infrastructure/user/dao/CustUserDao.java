package com.ljk.infrastructure.user.dao;


import com.ljk.infrastructure.user.po.CustUserPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liujiankun
 * @date 2020/4/30 16:39
 */
@Repository
public interface CustUserDao extends CrudRepository<CustUserPO, Long> {
}
