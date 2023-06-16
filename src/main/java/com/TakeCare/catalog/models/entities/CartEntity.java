package com.TakeCare.catalog.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String name;
    private double price;
    private int quantity;

    

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartEntity() {
    }

    public CartEntity( String name, double price, int quantity, UserEntity user) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.user = user;
    }

    public CartEntity id(int id) {
        setId(id);
        return this;
    }

    public CartEntity name(String name) {
        setName(name);
        return this;
    }

    public CartEntity price(double price) {
        setPrice(price);
        return this;
    }

    public CartEntity quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", price='" + getPrice() + "'" +
                ", quantity='" + getQuantity() + "'" +
                "}";
    }
}
