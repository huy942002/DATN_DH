package com.example.backend.repository.imp;

import com.example.backend.entities.Payment;
import com.example.backend.repository.irepo.IPaymentService;
import com.example.backend.repository.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImp implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Iterable<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void remove(Integer id) {
        paymentRepository.deleteById(id);
    }
}
