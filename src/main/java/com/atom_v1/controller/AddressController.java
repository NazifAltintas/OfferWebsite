package com.atom_v1.controller;

import com.atom_v1.data.Address;
import com.atom_v1.services.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }

    @GetMapping(path="/getAllAddresses")
    public List<Address> getAllAddresses(){

        return addressService.getAllAddresses();
    }

    @GetMapping(path="/getAllAddressById/{id}")
    public Address getAddressById(@PathVariable Long id) {

        return addressService.getAddressById(id);
    }
}
