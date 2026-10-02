package com.pedro.projetospringboot.repositories;

import com.pedro.projetospringboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
