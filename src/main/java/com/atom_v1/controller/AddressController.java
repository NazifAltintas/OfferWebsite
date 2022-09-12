package com.atom_v1.controller;

import com.atom_v1.data.Address;
import com.atom_v1.services.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }

    @GetMapping(path = "xxx")
    public String test(){
        return "blog";
    }

    @GetMapping(path="/getAllAddresses")
    public List<Address> getAllAddresses(){

        return addressService.getAllAddresses();
    }

    @GetMapping(path="/getAllAddressById/{id}")
    public Address getAddressById(@PathVariable Long id) {

        return addressService.getAddressById(id);
    }

    @DeleteMapping(path = "/deleteStudent/{id}")
    public String deleteAddressById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }

    @PutMapping(path = "/updateAddress/{id}")
    public Address fullyUpdateAddressById(@PathVariable Long id,@Validated @RequestBody Address newAddress){
        return addressService.fullyUpdateAddress(id,newAddress);
    }
}
