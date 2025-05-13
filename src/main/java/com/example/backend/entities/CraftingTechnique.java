package com.example.backend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "CraftingTechnique")
public class CraftingTechnique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer techniqueId;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(50)")
    private String techniqueName;

    @Nationalized
    @Column(columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name= "Active",nullable = false)
    private boolean isActive = true;

    public CraftingTechnique() {}

    // Getters and Setters
    public Integer getTechniqueId() { return techniqueId; }
    public void setTechniqueId(Integer techniqueId) { this.techniqueId = techniqueId; }
    public String getTechniqueName() { return techniqueName; }
    public void setTechniqueName(String techniqueName) { this.techniqueName = techniqueName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
