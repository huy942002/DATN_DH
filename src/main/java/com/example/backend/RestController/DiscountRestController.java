package com.example.backend.RestController;

import com.example.backend.entities.Discount;
import com.example.backend.repository.imp.DiscountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/discounts")
public class DiscountRestController {
    @Autowired
    private DiscountServiceImp discountService;

    @GetMapping
    public ResponseEntity<Iterable<Discount>> getAllDiscounts() {
        Iterable<Discount> categories = discountService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Get Category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Discount> getCategoryById(@PathVariable int id) {
        Optional<Discount> Discount = discountService.findById(id);
        return Discount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    public ResponseEntity<Discount> updateProductColor(@RequestBody Discount discount) {
        return ResponseEntity.ok(discountService.save(discount));
    }
    // Delete Category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        discountService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
