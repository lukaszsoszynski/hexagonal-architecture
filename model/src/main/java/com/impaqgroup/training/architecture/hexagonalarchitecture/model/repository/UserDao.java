package com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.InputPort;

import java.util.Optional;

@InputPort
public interface UserDao {
    void create(User user);
    Optional<User> findByEmail(String email);
}
