package com.TakeCare.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TakeCare.catalog.models.entities.UserEntity;
import com.TakeCare.catalog.models.repos.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/account")
    public String account(Model model, HttpServletRequest request){
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        if (user != null){
            model.addAttribute("user", user);
            model.addAttribute("first_name", "");
            model.addAttribute("last_name", "");
            model.addAttribute("email", "");
            model.addAttribute("phoneNumber", "");
            return "account";
        } else {
            return "login";
        }
    }

    @PostMapping("/update")
    public String updateProfile(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name, @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,  Model model, HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        if (user != null) {
            user.setFirst_name(first_name);
            user.setLast_name(last_name);
            user.setEmail(email);
            user.setPhone_Number(phoneNumber);
            userRepo.save(user);
            return "redirect:/account";
        } else {
            return "login";
        }
    }

    @PostMapping("/login")
    public String logoutUser(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "login";
    }
}
