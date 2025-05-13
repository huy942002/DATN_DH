//package com.example.backend.RestController;
//
//import com.example.backend.dto.CustomerDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/customers")
//public class CustomerRestController {
//    @Autowired
//    private CustomerDTOServiceImp customerService;
//
//    @GetMapping
//    public List<CustomerDTO> getAllCustomers() {
//        return customerService.getAllCustomers();
//    }
//
//    @PostMapping
//    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO dto) {
//        return ResponseEntity.ok(customerService.createCustomer(dto));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO dto) {
//        return ResponseEntity.ok(customerService.updateCustomer(id, dto));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
//        customerService.deleteCustomer(id);
//        return ResponseEntity.noContent().build();
//    }
//}
