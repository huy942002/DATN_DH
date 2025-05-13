package com.example.backend.repository.repo;

import com.example.backend.entities.Customer;
import com.example.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByIsActiveTrue();
    Optional<Customer> findByUserAndIsActiveTrue(User user);
    Optional<Customer> findByEmailAndIsActiveTrue(String email);
}
