package com.example.backend.repository.repo;

import com.example.backend.entities.Product;
import com.example.backend.entities.ProductColorDetail;
import com.example.backend.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement,Integer> {
    List<StockMovement> findByProductAndIsActiveTrue(Product product);
    List<StockMovement> findByProductColorDetailAndIsActiveTrue(ProductColorDetail productColorDetail);
    List<StockMovement> findByIsActiveTrue();
    List<StockMovement> findByMovementTypeAndIsActiveTrue(String movementType);
}
