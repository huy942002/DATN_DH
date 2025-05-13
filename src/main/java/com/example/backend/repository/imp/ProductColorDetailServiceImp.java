package com.example.backend.repository.imp;

import com.example.backend.entities.ProductColorDetail;
import com.example.backend.repository.irepo.IProductColorDetailService;
import com.example.backend.repository.repo.ProductColorDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductColorDetailServiceImp implements IProductColorDetailService {
    @Autowired
    private ProductColorDetailRepository colorDetailRepository;
    @Override
    public Iterable<ProductColorDetail> findAll() {
        return colorDetailRepository.findAll();
    }

    @Override
    public Optional<ProductColorDetail> findById(Integer id) {
        return colorDetailRepository.findById(id);
    }

    @Override
    public ProductColorDetail save(ProductColorDetail productColorDetail) {
        return colorDetailRepository.save(productColorDetail);
    }

    @Override
    public void remove(Integer id) {
        colorDetailRepository.deleteById(id);
    }
}
