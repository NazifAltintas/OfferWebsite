package com.atom_v1.controller;

import com.atom_v1.data.Category;
import com.atom_v1.data.Location;

import com.atom_v1.services.implementations.LocationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {

    private LocationServiceImpl locationService;

    @Autowired
    public LocationController(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }

    @GetMapping(path = "")
    public String showAllLocations(Model model) {



        return "index";
    }


}

