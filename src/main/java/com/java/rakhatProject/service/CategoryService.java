package com.java.rakhatProject.service;

import com.java.rakhatProject.entity.Category;
import com.java.rakhatProject.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category save(Category group) {
        return categoryRepository.save(group);
    }
}
