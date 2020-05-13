package com.ljk.application.user.command;

import com.ljk.application.user.command.cmd.CustUserAddCommand;
import com.ljk.application.user.command.cmd.CustUserDeleteCommand;

/**
 * @author liujiankun
 * @date 2020/4/30 17:27
 */

public interface CustUserService {
    void add(CustUserAddCommand addCommand);
    void delete(CustUserDeleteCommand deleteCommand);
}
