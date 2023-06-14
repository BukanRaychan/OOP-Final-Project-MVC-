package com.TakeCare.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.TakeCare.catalog.models.entities.UserEntity;
import com.TakeCare.catalog.models.repos.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        if (user != null){
            return "home";
        }
        model.addAttribute("email", "");
        model.addAttribute("password", "");
        return "login";
    }

    @PostMapping("/loginButtonClicked")
    public String loginn(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        UserEntity user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user",user);
            return "home";
        }
        return "login";
    }
}
