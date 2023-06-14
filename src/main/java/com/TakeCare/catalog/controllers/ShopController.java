package com.TakeCare.catalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TakeCare.catalog.models.entities.ChartEntity;
import com.TakeCare.catalog.models.entities.ShopEntity;
import com.TakeCare.catalog.models.entities.UserEntity;
import com.TakeCare.catalog.models.repos.ChartRepository;
import com.TakeCare.catalog.models.repos.ShopRepository;
import com.TakeCare.catalog.models.repos.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopController {

    @Autowired
    private ChartRepository chartRepo;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/shop")
    public String shop(Model model, HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        if (user != null) {
            List<ChartEntity>chartList = chartRepo.findByUserId(user.getId());
            model.addAttribute("idBarang", 0);
            model.addAttribute("quantity", 0);
            model.addAttribute("chartItems", chartList);
            return "shop";
        }
        return "login";

    }

    @PostMapping("/addToChart")
    public String addToChart(@RequestParam("idBarang") int idBarang, @RequestParam("quantity") int quantity,
            HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        ShopEntity item = shopRepository.findById(idBarang).orElse(null);
        System.out.println(idBarang + " " + quantity + item.getName());
        if (user != null && item != null) {
            ChartEntity existingItem = null;
            for (ChartEntity chartItem : user.getChart()) {
                if (chartItem.getName().equals(item.getName())) {
                    existingItem = chartItem;
                    break;
                }
            }

            if (existingItem != null) {
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
            } else {
                ChartEntity newChartEntity = new ChartEntity(item.getName(), item.getPrice(), quantity);
                newChartEntity.setUser(user);
                user.addChart(newChartEntity);
            }
            userRepo.save(user);
        }
        return "redirect:/shop";
    }

}
