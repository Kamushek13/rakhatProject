package com.java.rakhatProject.service;

import com.java.rakhatProject.entity.Order;
import com.java.rakhatProject.entity.Product;
import com.java.rakhatProject.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getByCategoryId(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    public Product save(Product group) {
        return productRepository.save(group);
    }

    public Object addStock(Long productID, Long stock) {
        Product product = productRepository.findByProductId(productID);
        product.setStock(product.getStock()+stock);
        return productRepository.save(product);
    }
}
