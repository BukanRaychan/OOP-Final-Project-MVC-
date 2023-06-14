package com.TakeCare.catalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InitController {
    
    @GetMapping("/")
    public String init(Model model){
        return "init";
    }
}
