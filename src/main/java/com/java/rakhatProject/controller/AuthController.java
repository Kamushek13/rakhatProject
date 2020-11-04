package com.java.rakhatProject.controller;

import com.java.rakhatProject.entity.Auth;

import com.java.rakhatProject.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Auth auth) {
        try {
            return ResponseEntity.ok(authService.login(auth));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/customer/me")
    public ResponseEntity<?> me(@RequestHeader("Auth") String token) throws Exception {
        return ResponseEntity.ok(authService.getCustomerByToken(token));
    }

}
