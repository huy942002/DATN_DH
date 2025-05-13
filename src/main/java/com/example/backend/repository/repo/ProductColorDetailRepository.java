package com.example.backend.repository.repo;

import com.example.backend.entities.Product;
import com.example.backend.entities.ProductColor;
import com.example.backend.entities.ProductColorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductColorDetailRepository extends JpaRepository<ProductColorDetail,Integer> {
    List<ProductColorDetail> findByProduct(Product product);
    void deleteByProduct(Product product);

    List<ProductColorDetail> findByProductAndIsActiveTrue(Product product);
    List<ProductColorDetail> findByColorAndIsActiveTrue(ProductColor color);
    Optional<ProductColorDetail> findByProductAndColorAndIsActiveTrue(Product product, ProductColor color);
    List<ProductColorDetail> findByIsActiveTrue();
}
