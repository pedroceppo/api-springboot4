package com.pedro.projetospringboot.repositories;

import com.pedro.projetospringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
