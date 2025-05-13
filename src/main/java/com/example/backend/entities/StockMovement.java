package com.example.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "StockMovements")
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockMovementId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_color_relation_id")
    private ProductColorDetail productColorDetail;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 50)
    private String movementType;

    @Column
    private LocalDateTime movementDate = LocalDateTime.now();

    @Column(columnDefinition = "NVARCHAR(255)")
    private String reason;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name= "Active",nullable = false)
    private boolean isActive = true;

    public StockMovement() {}

    // Getters and Setters
    public Integer getStockMovementId() { return stockMovementId; }
    public void setStockMovementId(Integer stockMovementId) { this.stockMovementId = stockMovementId; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public ProductColorDetail getProductColorDetail() { return productColorDetail; }
    public void setProductColorDetail(ProductColorDetail productColorDetail) { this.productColorDetail = productColorDetail; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getMovementType() { return movementType; }
    public void setMovementType(String movementType) { this.movementType = movementType; }
    public LocalDateTime getMovementDate() { return movementDate; }
    public void setMovementDate(LocalDateTime movementDate) { this.movementDate = movementDate; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
