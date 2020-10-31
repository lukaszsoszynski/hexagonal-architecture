package com.impaqgroup.training.architecture.hexagonalarchitecture.repository.jpa;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
