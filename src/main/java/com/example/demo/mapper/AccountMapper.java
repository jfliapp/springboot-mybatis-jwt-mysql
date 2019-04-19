package com.example.demo.mapper;

import com.example.demo.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    public Account loginAccount(Account account);

}
