package com.swathimart.swathi_mart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swathimart.swathi_mart.CartItem;

import java.util.List;

@RestController
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/cart")
    public List<CartItem> getCart() {
        return cartRepository.findAll();
    }
}
