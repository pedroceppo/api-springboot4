package com.pedro.projetospringboot.repositories;

import com.pedro.projetospringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
