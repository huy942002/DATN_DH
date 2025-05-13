package com.example.backend.repository.repo;

import com.example.backend.entities.Product;
import com.example.backend.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {
    List<ProductImage> findByProduct(Product product);
    void deleteByProduct(Product product);
    List<ProductImage> findByProductProductId(Integer productId);
    List<ProductImage> findByProductAndIsActiveTrue(Product product);
    List<ProductImage> findByIsMainImageTrueAndIsActiveTrue();
    List<ProductImage> findByIsActiveTrue();
}
