package com.atom_v1.controller;

import com.atom_v1.data.Address;
import com.atom_v1.data.User;
import com.atom_v1.services.interfaces.AddressService;
import com.atom_v1.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private AddressService addressService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/addUserForm")
    public String showForm(Model model) {

        model.addAttribute("user", new User());

        return "registrationPage";
    }

    @PostMapping("/createdNewUser")
    public String createUser(@ModelAttribute("user") User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoderPassword = encoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
        userService.createUser(user);

        return "addAddress";
    }

    @PostMapping("/addAddress")
    public String createAddress(@ModelAttribute("addresses") Address address) {
        User userOfAddress=userService.getUserById(1L);
        for(User user: userService.getAllUsers()){
            userOfAddress=user;
        }
        userOfAddress.setAddresses(List.of(address));
        addressService.createAddress(address);

        return "registrationSuccess";
    }


}
