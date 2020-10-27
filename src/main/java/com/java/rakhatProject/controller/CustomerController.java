package com.java.rakhatProject.controller;

import com.java.rakhatProject.entity.Customer;
import com.java.rakhatProject.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<?> getCustomer() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @PutMapping("/customer")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.edit(customer));
    }

    @DeleteMapping("customer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }
}
