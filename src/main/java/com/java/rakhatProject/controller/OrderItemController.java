package com.java.rakhatProject.controller;

import com.java.rakhatProject.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class OrderItemController {
    private OrderItemService orderItemService;

    @GetMapping("orders/orderItem")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderItemService.getAll());
    }

}
