package com.example.backend.repository.irepo;

import com.example.backend.dto.ProductDTO;
import com.example.backend.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IProductService extends IGeneralService<Product> {
    List<ProductDTO> findAllProductDTO();
    ProductDTO findByIdProductDTO(Integer id);
    ProductDTO create(ProductDTO productDTO);
    ProductDTO update(Integer id, ProductDTO productDTO);
    void delete(Integer id);
}
