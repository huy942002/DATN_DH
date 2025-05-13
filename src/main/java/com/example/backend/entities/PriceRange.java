package com.example.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PriceRange")
public class PriceRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceRangeId;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(100)")
    private String priceRangeName;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name= "Active",nullable = false)
    private boolean isActive = true;

    public PriceRange() {}

    // Getters and Setters
    public Integer getPriceRangeId() { return priceRangeId; }
    public void setPriceRangeId(Integer priceRangeId) { this.priceRangeId = priceRangeId; }
    public String getPriceRangeName() { return priceRangeName; }
    public void setPriceRangeName(String priceRangeName) { this.priceRangeName = priceRangeName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
