package com.pedro.projetospringboot.services;

import com.pedro.projetospringboot.entities.Order;
import com.pedro.projetospringboot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService{

    @Autowired
    OrderRepository orderRepository;


    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);

        return obj.get();
    }
}
