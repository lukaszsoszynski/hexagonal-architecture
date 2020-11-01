package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.UserDto;

import java.util.Optional;

public interface RestUserService {
    void createUser(UserDto userDto);

    Optional<UserDto> findUserByEmail(String userId);
}
