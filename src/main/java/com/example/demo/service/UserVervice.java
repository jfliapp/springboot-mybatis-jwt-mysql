package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVervice {
    @Autowired
    private UserMapper userMapper;

    public User find(Long id) {
        return userMapper.find(id);
    }

}
