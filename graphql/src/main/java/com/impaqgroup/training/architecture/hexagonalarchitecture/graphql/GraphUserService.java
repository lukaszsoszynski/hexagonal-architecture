package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;

import java.util.Optional;

public interface GraphUserService {
    Optional<GraphUserDto> findUserByEmail(String email);
}
