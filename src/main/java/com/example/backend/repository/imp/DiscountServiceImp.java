package com.example.backend.repository.imp;

import com.example.backend.entities.Discount;
import com.example.backend.repository.irepo.IDiscountService;
import com.example.backend.repository.repo.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DiscountServiceImp implements IDiscountService {
    @Autowired
    private DiscountRepository discountRepository;
    @Override
    public Iterable<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Optional<Discount> findById(Integer id) {
        return discountRepository.findById(id);
    }

    @Override
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public void remove(Integer id) {
        discountRepository.deleteById(id);
    }
}
