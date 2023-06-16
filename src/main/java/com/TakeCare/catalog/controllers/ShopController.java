package com.TakeCare.catalog.controllers;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TakeCare.catalog.models.entities.CartEntity;
import com.TakeCare.catalog.models.entities.ShopEntity;
import com.TakeCare.catalog.models.entities.UserEntity;
import com.TakeCare.catalog.models.repos.CartRepository;
import com.TakeCare.catalog.models.repos.ShopRepository;
import com.TakeCare.catalog.models.repos.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Controller
@Transactional
public class ShopController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/shop")
    public String shop(Model model, HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        if (user != null) {
            List<CartEntity> cartList = cartRepository.findByUserId(user.getId());
            List<ShopEntity> shopList = shopRepository.findAll();
            model.addAttribute("idBarang", 0);
            model.addAttribute("quantity", 0);
            model.addAttribute("cartItems", cartList);
            model.addAttribute("shopItems", shopList);
            return "shop";
        }
        return "login";

    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("idBarang") int idBarang, @RequestParam("quantity") int quantity,
                        HttpServletRequest request) {
        if(quantity != 0){
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            ShopEntity item = shopRepository.findById(idBarang).orElse(null);
            if (user != null && item != null) {
                for (CartEntity chartItem : cartRepository.findByUserId(user.getId())) {
                    if (chartItem.getName().equals(item.getName())) {
                        chartItem.setQuantity(chartItem.getQuantity() + quantity);
                        cartRepository.save(chartItem);
                        return "redirect:/shop";
                    }
                }
                CartEntity newCartItem = new CartEntity(item.getName(), item.getPrice(), quantity, user);
                cartRepository.save(newCartItem);
            }
        }
        return "redirect:/shop";
    }


    @PostMapping("/deleteCart")
    public String deleteCart(@RequestParam("idDelete") int idDelete){
        cartRepository.deleteById(idDelete);
        return "redirect:/shop";
    }

    @PostMapping("/addToOrder")
    public String addToOrder(@RequestParam("cart") CartEntity cart){
        return "/account";
    }
}
