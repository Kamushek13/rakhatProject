package com.java.rakhatProject.controller;

import com.java.rakhatProject.service.CategoryService;
import com.java.rakhatProject.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StatusController {

    private StatusService statusService;

    @GetMapping("/status")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(statusService.getAll());
    }

}
