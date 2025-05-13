package com.example.backend.repository.repo;

import com.example.backend.entities.Order;
import com.example.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByIsActiveTrue();
    List<Order> findByUserAndIsActiveTrue(User user);
    List<Order> findByStatusAndIsActiveTrue(String status);

}
