package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;

import java.util.Optional;

public interface GraphThreadService {
    Optional<GraphThreadDto> findThreadById(Long threadId);
}
