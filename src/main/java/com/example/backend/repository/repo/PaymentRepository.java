package com.example.backend.repository.repo;

import com.example.backend.entities.Order;
import com.example.backend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findByOrderAndIsActiveTrue(Order order);
    List<Payment> findByIsActiveTrue();
    List<Payment> findByPaymentStatusAndIsActiveTrue(String paymentStatus);
}
