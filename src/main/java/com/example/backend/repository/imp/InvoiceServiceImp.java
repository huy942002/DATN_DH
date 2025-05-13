package com.example.backend.repository.imp;

import com.example.backend.entities.Invoice;
import com.example.backend.repository.irepo.IInvoiceService;
import com.example.backend.repository.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class InvoiceServiceImp implements IInvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public Iterable<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> findById(Integer id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void remove(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
