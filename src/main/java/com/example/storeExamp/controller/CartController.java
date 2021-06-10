package com.example.storeExamp.controller;

import com.example.storeExamp.component.Cart;
import com.example.storeExamp.dto.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor

public class CartController {
    private final Cart cart;

    @GetMapping
    public List<OrderItem> findAll() {
        return cart.findAll();
    }

    @GetMapping("/{id}")
    public void addProductToCart(@PathVariable Long id){
        cart.addCart(id);
}
    @DeleteMapping ("/{id}")
        public void subProductToCart(@PathVariable Long id){
        cart.subCart(id);
        }
    @GetMapping("/fullprice")
    public Integer fullCartPrice(){
        return cart.fullCartPrice();
    }
}

