package com.example.demo.mapper;

import com.example.demo.domain.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressMapper {
    public Address find(Long id);

}
