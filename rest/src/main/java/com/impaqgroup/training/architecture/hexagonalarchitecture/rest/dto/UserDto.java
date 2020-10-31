package com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UserDto {
    private String email;
    private String firstName;
    private String surname;
    private String password;
    private LocalDateTime dateOfBirth;
}
