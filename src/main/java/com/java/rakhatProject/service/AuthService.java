package com.java.rakhatProject.service;

import com.java.rakhatProject.entity.Auth;
import com.java.rakhatProject.entity.Customer;
import com.java.rakhatProject.repository.AuthRepository;
import com.java.rakhatProject.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public Auth login(Auth auth) throws Exception {
        Auth authDB = authRepository.findByUsernameAndPassword(auth.getUsername(), auth.getPassword());

        if(authDB == null) {
            throw  new Exception();
        }

        String token = UUID.randomUUID().toString();

        authDB.setToken(token);
        return authRepository.save(authDB);
    }
    public Customer getCustomerByToken(String token) throws Exception {
        Auth authDB = authRepository.findByToken(token);
        return customerRepository.findById(authDB.getCustomerId()).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}


