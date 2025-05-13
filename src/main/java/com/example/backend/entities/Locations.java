package com.example.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Locations")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(100)")
    private String locationName;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name= "Active",nullable = false)
    private boolean isActive = true;


    // Getters and Setters
    public Integer getLocationId() { return locationId; }
    public void setLocationId(Integer locationId) { this.locationId = locationId; }
    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
