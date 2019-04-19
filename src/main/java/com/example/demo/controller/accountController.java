package com.example.demo.controller;

import com.example.demo.domain.Account;
import com.example.demo.service.AccountService;
import com.example.demo.utils.JWTUtils;
import com.example.demo.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/api/hello")
    public String Hello(@RequestHeader("Authorization") String token) {
        System.out.println(token+"Authoirizdfaijoj token de zhi");
        return "hello world";
    }

    @RequestMapping(value = "/accountLogin",method = RequestMethod.POST)
    public Results login(@RequestBody Account account) {

        Account accountName = accountService.loginAccount(account);

        if(accountName != null) {
            String jwt = JWTUtils.generateToken(account.getUserName());
            return new Results(1, "ok", jwt);
        }

        return new Results(0,"error", "账户或密码错误");

    }

}
