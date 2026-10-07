package com.swathimart.swathi_mart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swathimart.swathi_mart.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
