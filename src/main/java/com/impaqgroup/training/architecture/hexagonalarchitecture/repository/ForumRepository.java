package com.impaqgroup.training.architecture.hexagonalarchitecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, String> {
}
