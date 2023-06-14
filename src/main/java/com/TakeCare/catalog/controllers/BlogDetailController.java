package com.TakeCare.catalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogDetailController {
    @GetMapping("/blog-details")
    public String blogDetails(Model model){
        return "blog-details";
    }
}
