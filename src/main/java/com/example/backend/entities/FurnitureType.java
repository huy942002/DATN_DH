package com.example.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FurnitureType")
public class FurnitureType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer furnitureTypeId;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(100)")
    private String typeName;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name= "Active",nullable = false)
    private boolean isActive = true;

    public FurnitureType() {}

    // Getters and Setters
    public Integer getFurnitureTypeId() { return furnitureTypeId; }
    public void setFurnitureTypeId(Integer furnitureTypeId) { this.furnitureTypeId = furnitureTypeId; }
    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}