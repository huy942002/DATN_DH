package com.example.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Style")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer styleId;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(100)")
    private String styleName;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name= "Active",nullable = false)
    private boolean isActive = true;

    public Style() {}

    // Getters and Setters
    public Integer getStyleId() { return styleId; }
    public void setStyleId(Integer styleId) { this.styleId = styleId; }
    public String getStyleName() { return styleName; }
    public void setStyleName(String styleName) { this.styleName = styleName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
