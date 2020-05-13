package com.ljk.interfaces.user;


import com.ljk.application.user.command.CustUserService;
import com.ljk.application.user.command.cmd.CustUserAddCommand;
import com.ljk.application.user.command.cmd.CustUserDeleteCommand;
import com.ljk.application.user.query.CustUserQuery;
import com.ljk.application.user.query.vo.CustUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liujiankun
 * @date 2020/4/30 19:29
 */
@RestController
@RequestMapping("/cust/user")
public class CustUserController {
    @Autowired
    private CustUserService custUserService;
    @Autowired
    private CustUserQuery custUserQuery;

    @PostMapping(path = "/")
    public void addCustUser(@RequestBody CustUserAddCommand addCommand){
        custUserService.add(addCommand);
    }


    @GetMapping(path = "/{id}")
    public CustUserVO get(@PathVariable Long id){
        return custUserQuery.find(id);
    }


    @DeleteMapping(path = "/{id}")
    public void addCustUser(@PathVariable Long id){
        CustUserDeleteCommand deleteCommand = new CustUserDeleteCommand();
        deleteCommand.setId(id);
        custUserService.delete(deleteCommand);
    }
}
