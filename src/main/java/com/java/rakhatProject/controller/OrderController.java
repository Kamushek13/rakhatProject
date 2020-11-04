package com.java.rakhatProject.controller;

import com.java.rakhatProject.entity.OrderProducts;
import com.java.rakhatProject.entity.Product;
import com.java.rakhatProject.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class OrderController {
    private OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }


    @PostMapping("/order/create")
    public ResponseEntity<?> createOder(@RequestHeader("tokenOfAccount") String tokenOfAccount, @RequestBody OrderProducts listProducts){
        return ResponseEntity.ok(orderService.create(tokenOfAccount, listProducts));
    }

    @GetMapping("/myOrders")
    public ResponseEntity<?> getCustomerOrder(@RequestHeader("tokenOfAccount") String tokenOfAccount){
        return ResponseEntity.ok(orderService.getCustomerOrder(tokenOfAccount));
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getOrders(){
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping("status/change")
    public ResponseEntity<?> changeStatus(@RequestHeader("OrderToken") String orderToken){
        return ResponseEntity.ok(orderService.changeStatus(orderToken));
    }

}
