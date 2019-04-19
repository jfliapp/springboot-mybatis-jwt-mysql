package com.example.demo.service;

import com.example.demo.domain.Address;
import com.example.demo.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressVervice {
    @Autowired
    private AddressMapper addressMapper;

    public Address find(Long id) {
        return addressMapper.find(id);
    }
}
