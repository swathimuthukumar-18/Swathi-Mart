package com.swathimart.swathi_mart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swathimart.swathi_mart.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
