package com.pedro.projetospringboot.repositories;

import com.pedro.projetospringboot.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
