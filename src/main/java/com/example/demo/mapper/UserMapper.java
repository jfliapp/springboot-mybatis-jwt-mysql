package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User find(Long id);
}
