package com.impaqgroup.training.architecture.hexagonalarchitecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
