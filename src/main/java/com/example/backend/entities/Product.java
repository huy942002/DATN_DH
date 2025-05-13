package com.example.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false, columnDefinition = "NVARCHAR(200)", unique = true)
    @NotBlank(message = "Product name is required")
    private String productName;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(nullable = false)
    @Min(value = 0, message = "Price must be non-negative")
    private BigDecimal price;

    @Column(nullable = false)
    @Min(value = 0, message = "Weight must be non-negative")
    private BigDecimal weight;

    @Column(columnDefinition = "NVARCHAR(100)")
    private String dimensions;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "function_id")
    private Functions function;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style style;

    @ManyToOne
    @JoinColumn(name = "wood_type_id")
    private WoodType woodType;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations location;

    @ManyToOne
    @JoinColumn(name = "technique_id")
    private CraftingTechnique technique;

    @ManyToOne
    @JoinColumn(name = "price_range_id")
    private PriceRange priceRange;

    @ManyToOne
    @JoinColumn(name = "furniture_type_id")
    private FurnitureType furnitureType;

    @Column(nullable = false, length = 50)
    private String productStatus = "Available";

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "Active", nullable = false)
    private Boolean isActive = true;

    @OneToMany(mappedBy = "product")
    private List<ProductColorDetail> colorDetails;

    public Product() {}

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }
    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Functions getFunction() { return function; }
    public void setFunction(Functions function) { this.function = function; }
    public Style getStyle() { return style; }
    public void setStyle(Style style) { this.style = style; }
    public WoodType getWoodType() { return woodType; }
    public void setWoodType(WoodType woodType) { this.woodType = woodType; }
    public Locations getLocation() { return location; }
    public void setLocation(Locations location) { this.location = location; }
    public CraftingTechnique getTechnique() { return technique; }
    public void setTechnique(CraftingTechnique technique) { this.technique = technique; }
    public PriceRange getPriceRange() { return priceRange; }
    public void setPriceRange(PriceRange priceRange) { this.priceRange = priceRange; }
    public FurnitureType getFurnitureType() { return furnitureType; }
    public void setFurnitureType(FurnitureType furnitureType) { this.furnitureType = furnitureType; }
    public String getProductStatus() { return productStatus; }
    public void setProductStatus(String name) { this.productStatus = name; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public Boolean isActive() { return isActive; }
    public void setActive(Boolean active) { isActive = active; }
    public List<ProductColorDetail> getColorDetails() { return colorDetails; }
    public void setColorDetails(List<ProductColorDetail> colorDetails) { this.colorDetails = colorDetails; }
}