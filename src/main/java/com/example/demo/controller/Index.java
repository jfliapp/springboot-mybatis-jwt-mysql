package com.example.demo.controller;

import com.example.demo.domain.Account;
import com.example.demo.domain.User;
import com.example.demo.service.UserVervice;
import com.example.demo.utils.JWTUtils;
import com.example.demo.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class Index {
    @Autowired
    private UserVervice userVervice;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String PostTest(@RequestBody Account account) { // @RequestParam("name") String name,
        System.out.println(account);
        System.out.println(account.getUserName());
        System.out.println(account.getPassword());

        return "post";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST )
    public Object login(@RequestBody Account account) throws Exception{
        System.out.println(account + "请求的数据是什么呢++++++++++++++++++++++++++++++++++");
        System.out.println(account.getUserName().equals("admin"));
        if(account.getUserName().equals("admin")){
            if(account.getPassword().equals("123456")){
                String jwt = JWTUtils.generateToken(account.getUserName());
                HashMap<String, String> map= new HashMap<>();
                map.put("token", jwt);
                return map;
            }
        }else {
            return "error token";
        }
       return "Object";
    }

    @RequestMapping(value = "/api/user/{id}")
    public Results find(@PathVariable Long id) {
        User userWithAddress = userVervice.find(id);
        if(userWithAddress == null) {
            return new Results(1, "没有这个数据");
        }
        return new Results(1, "success", userWithAddress);
    }

}


