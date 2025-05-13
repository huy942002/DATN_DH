package com.example.backend.repository.imp;

import com.example.backend.dto.ProductDTO;
import com.example.backend.dto.ReferenceDTO;
import com.example.backend.entities.*;
import com.example.backend.repository.irepo.IProductService;
import com.example.backend.repository.repo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findByIsActiveTrue();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        if (product.getProductId() == null) {
            product.setCreatedAt(LocalDateTime.now());
        }
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setActive(false);
            product.setUpdatedAt(LocalDateTime.now());
            productRepository.save(product);
        }
    }

    @Override
    public List<ProductDTO> findAllProductDTO() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findByIdProductDTO(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return convertToDTO(product);
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = new Product();
        mapDTOToEntity(productDTO, product);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    @Override
    public ProductDTO update(Integer id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        mapDTOToEntity(productDTO, product);
        Product updatedProduct = productRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    @Override
    public void delete(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getDimensions(),
                product.getProductStatus(),
                product.isActive(),
                product.getImageUrl(),
                product.getCategory() != null ? new ReferenceDTO(product.getCategory().getCategoryId(), product.getCategory().getCategoryName()) : null,
                product.getFunction() != null ? new ReferenceDTO(product.getFunction().getFunctionId(), product.getFunction().getFunctionName()) : null,
                product.getStyle() != null ? new ReferenceDTO(product.getStyle().getStyleId(), product.getStyle().getStyleName()) : null,
                product.getWoodType() != null ? new ReferenceDTO(product.getWoodType().getWoodTypeId(), product.getWoodType().getWoodTypeName()) : null,
                product.getLocation() != null ? new ReferenceDTO(product.getLocation().getLocationId(), product.getLocation().getLocationName()) : null,
                product.getTechnique() != null ? new ReferenceDTO(product.getTechnique().getTechniqueId(), product.getTechnique().getTechniqueName()) : null,
                product.getPriceRange() != null ? new ReferenceDTO(product.getPriceRange().getPriceRangeId(), product.getPriceRange().getPriceRangeName()) : null,
                product.getFurnitureType() != null ? new ReferenceDTO(product.getFurnitureType().getFurnitureTypeId(), product.getFurnitureType().getTypeName()) : null
        );
    }

    private void mapDTOToEntity(ProductDTO dto, Product product) {
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setWeight(dto.getWeight());
        product.setDimensions(dto.getDimensions());
        product.setProductStatus(dto.getProductStatus());
        product.setActive(dto.getActive());
        product.setImageUrl(dto.getImageUrl());
        if (dto.getCategory() != null && dto.getCategory().getId() != null) {
            Category category = new Category();
            category.setCategoryId(dto.getCategory().getId());
            product.setCategory(category);
        }
        if (dto.getFunction() != null && dto.getFunction().getId() != null) {
            Functions function = new Functions();
            function.setFunctionId(dto.getFunction().getId());
            product.setFunction(function);
        }
        if (dto.getStyle() != null && dto.getStyle().getId() != null) {
            Style style = new Style();
            style.setStyleId(dto.getStyle().getId());
            product.setStyle(style);
        }
        if (dto.getWoodType() != null && dto.getWoodType().getId() != null) {
            WoodType woodType = new WoodType();
            woodType.setWoodTypeId(dto.getWoodType().getId());
            product.setWoodType(woodType);
        }
        if (dto.getLocation() != null && dto.getLocation().getId() != null) {
            Locations location = new Locations();
            location.setLocationId(dto.getLocation().getId());
            product.setLocation(location);
        }
        if (dto.getTechnique() != null && dto.getTechnique().getId() != null) {
            CraftingTechnique technique = new CraftingTechnique();
            technique.setTechniqueId(dto.getTechnique().getId());
            product.setTechnique(technique);
        }
        if (dto.getPriceRange() != null && dto.getPriceRange().getId() != null) {
            PriceRange priceRange = new PriceRange();
            priceRange.setPriceRangeId(dto.getPriceRange().getId());
            product.setPriceRange(priceRange);
        }
        if (dto.getFurnitureType() != null && dto.getFurnitureType().getId() != null) {
            FurnitureType furnitureType = new FurnitureType();
            furnitureType.setFurnitureTypeId(dto.getFurnitureType().getId());
            product.setFurnitureType(furnitureType);
        }
    }
}
