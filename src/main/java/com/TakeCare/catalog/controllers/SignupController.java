package com.TakeCare.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.TakeCare.catalog.models.entities.UserEntity;
import com.TakeCare.catalog.models.repos.UserRepository;

@Controller
public class SignupController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("first_name", "");
        model.addAttribute("last_name", "");
        model.addAttribute("email", "");
        model.addAttribute("phone_number", "");
        model.addAttribute("password", "");
        model.addAttribute("confirm_password", "");
        return "signup";
    }

    @PostMapping("/signupButtonClicked")
    public String signupButtonClicked(Model model, @RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name,
            @RequestParam("email") String email,
            @RequestParam("phone_number") String phone_number,
            @RequestParam("password") String password,
            @RequestParam("confirm_password") String confirm_password) {
        if (password.equals(confirm_password)) {
            UserEntity user = new UserEntity(first_name, last_name, email, phone_number, password);
            userRepo.save(user);
            return "redirect:/login";
        } else {
            model.addAttribute("first_name", first_name);
            model.addAttribute("last_name", last_name);
            model.addAttribute("email", email);
            model.addAttribute("phone_number", phone_number);
            model.addAttribute("password", password);
            model.addAttribute("confirm_password", "");
            return "signup";
        }
    }
}
