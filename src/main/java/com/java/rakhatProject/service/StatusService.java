package com.java.rakhatProject.service;

import com.java.rakhatProject.entity.Category;
import com.java.rakhatProject.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository;

    public List<Category> getAll() {
        return (List<Category>) statusRepository.findAll();
    }

    public Category save(Category group) {
        return statusRepository.save(group);
    }
}