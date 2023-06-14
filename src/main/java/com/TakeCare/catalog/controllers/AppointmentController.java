package com.TakeCare.catalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {

    @GetMapping("/appointment")
    public String appointment(Model model){
        return "appointment";
    }
}
