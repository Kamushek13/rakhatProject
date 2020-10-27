package com.java.rakhatProject.repository;

import com.java.rakhatProject.entity.Auth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRepository extends CrudRepository<Auth, Long> {
    Auth findByUsernameAndPassword(String username, String password);

    Auth findByToken(String token);
}
