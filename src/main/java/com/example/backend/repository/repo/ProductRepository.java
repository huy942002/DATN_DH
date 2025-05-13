package com.example.backend.repository.repo;

import com.example.backend.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @EntityGraph(attributePaths = {"category", "function", "style", "woodType", "location", "technique", "priceRange", "furnitureType"})
    List<Product> findByIsActiveTrue();

    @EntityGraph(attributePaths = {"category", "function", "style", "woodType", "location", "technique", "priceRange", "furnitureType"})
    Page<Product> findByIsActiveTrue(Pageable pageable);

    List<Product> findByProductNameContainingIgnoreCaseAndIsActiveTrue(String name);

    Page<Product> findByProductNameContainingIgnoreCaseAndIsActive(Boolean isActive, String name, Pageable pageable);
}