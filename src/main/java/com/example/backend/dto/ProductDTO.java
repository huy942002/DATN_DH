package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private final Integer productId;
    private final String productName;
    private final String description;
    private final BigDecimal price;
    private final BigDecimal weight;
    private final String dimensions;
    private final String productStatus;
    private final Boolean isActive;
    private final String imageUrl;
    private final ReferenceDTO category;
    private final ReferenceDTO function;
    private final ReferenceDTO style;
    private final ReferenceDTO woodType;
    private final ReferenceDTO location;
    private final ReferenceDTO technique;
    private final ReferenceDTO priceRange;
    private final ReferenceDTO furnitureType;

    public ProductDTO(
            Integer productId,
            String productName,
            String description,
            BigDecimal price,
            BigDecimal weight,
            String dimensions,
            String productStatus,
            Boolean isActive,
            String imageUrl,
            ReferenceDTO category,
            ReferenceDTO function,
            ReferenceDTO style,
            ReferenceDTO woodType,
            ReferenceDTO location,
            ReferenceDTO technique,
            ReferenceDTO priceRange,
            ReferenceDTO furnitureType
    ) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.dimensions = dimensions;
        this.productStatus = productStatus;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.category = category;
        this.function = function;
        this.style = style;
        this.woodType = woodType;
        this.location = location;
        this.technique = technique;
        this.priceRange = priceRange;
        this.furnitureType = furnitureType;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ReferenceDTO getCategory() {
        return category;
    }
    

    public ReferenceDTO getFunction() {
        return function;
    }

    public ReferenceDTO getStyle() {
        return style;
    }

    public ReferenceDTO getWoodType() {
        return woodType;
    }

    public ReferenceDTO getLocation() {
        return location;
    }

    public ReferenceDTO getTechnique() {
        return technique;
    }

    public ReferenceDTO getPriceRange() {
        return priceRange;
    }

    public ReferenceDTO getFurnitureType() {
        return furnitureType;
    }
}