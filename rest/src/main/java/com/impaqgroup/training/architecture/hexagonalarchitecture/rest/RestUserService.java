package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestUserDto;

import java.util.Optional;

public interface RestUserService {
    void createUser(RestUserDto userDto);

    Optional<RestUserDto> findUserByEmail(String userId);
}
