package com.swathimart.swathi_mart;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swathimart.swathi_mart.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
