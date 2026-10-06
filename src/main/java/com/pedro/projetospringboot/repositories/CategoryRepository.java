package com.pedro.projetospringboot.repositories;

import com.pedro.projetospringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
