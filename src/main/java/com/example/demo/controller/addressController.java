package com.example.demo.controller;

import com.example.demo.domain.Address;
import com.example.demo.service.AddressVervice;
import com.example.demo.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class addressController {

    @Autowired
    private AddressVervice addressVervice;

    @RequestMapping(value = "/")
    public String index() {
        return "hello address";
    }

    @RequestMapping(value = "/{id}")
    public Results indexAddress(@PathVariable Long id) {
        Address address = null;
        try {
            address = addressVervice.find(id);
            System.out.println(address + "what is this");
            if(address == null) {
                return new Results(1,"没有这个数据");
            }
        }catch (Exception e){
            return new Results(500,"error");
        }
        return new Results(1, "success", address);
    }
}
