package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account loginAccount(Account account){
        return accountMapper.loginAccount(account);
    }

}
