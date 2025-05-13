package com.example.backend.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Functions")
public class Functions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer functionId;

    @Column(nullable = false, unique = true, columnDefinition = "NVARCHAR(100)")
    private String functionName;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name= "Active",nullable = false)
    private boolean isActive = true;

    public Functions() {}

    // Getters and Setters
    public Integer getFunctionId() { return functionId; }
    public void setFunctionId(Integer functionId) { this.functionId = functionId; }
    public String getFunctionName() { return functionName; }
    public void setFunctionName(String functionName) { this.functionName = functionName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
