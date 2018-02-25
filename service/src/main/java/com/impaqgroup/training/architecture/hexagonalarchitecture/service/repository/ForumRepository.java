package com.impaqgroup.training.architecture.hexagonalarchitecture.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, String> {
}
