package com.example.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ProductViews")
public class ProductView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viewId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(columnDefinition = "NVARCHAR(100)")
    private String viewerIp;

    @Column(nullable = false)
    private LocalDateTime viewedAt = LocalDateTime.now();

    @Column(name= "Active",nullable = false)
    private boolean isActive = true;

    public ProductView() {}

    // Getters and Setters
    public Long getViewId() { return viewId; }
    public void setViewId(Long viewId) { this.viewId = viewId; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public String getViewerIp() { return viewerIp; }
    public void setViewerIp(String viewerIp) { this.viewerIp = viewerIp; }
    public LocalDateTime getViewedAt() { return viewedAt; }
    public void setViewedAt(LocalDateTime viewedAt) { this.viewedAt = viewedAt; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
