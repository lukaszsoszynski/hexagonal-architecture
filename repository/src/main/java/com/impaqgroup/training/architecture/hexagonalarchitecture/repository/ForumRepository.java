package com.impaqgroup.training.architecture.hexagonalarchitecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;

interface ForumRepository extends JpaRepository<Forum, String> {
}
