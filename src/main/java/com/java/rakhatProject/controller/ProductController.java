package com.java.rakhatProject.controller;

import com.java.rakhatProject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class ProductController {
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/product/category/{categoryID}")
    public ResponseEntity<?> getAllByCategory(@PathVariable("categoryID") Long categoryID) {
        return ResponseEntity.ok(productService.getByCategoryId(categoryID));
    }
}
