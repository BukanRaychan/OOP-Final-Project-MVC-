package com.TakeCare.catalog.models.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Controller
public class OrdersEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private CartEntity cartEntity;
    private LocalDateTime dateOrder;

    @JoinColumn(name = "user_id")
    private UserEntity user;

    
}
