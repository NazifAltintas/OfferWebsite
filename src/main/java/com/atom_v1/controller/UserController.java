package com.atom_v1.controller;

import com.atom_v1.data.Search;
import com.atom_v1.data.User;
import com.atom_v1.services.implementations.UserServiceImpl;
import com.atom_v1.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "nazif";
    }


}
