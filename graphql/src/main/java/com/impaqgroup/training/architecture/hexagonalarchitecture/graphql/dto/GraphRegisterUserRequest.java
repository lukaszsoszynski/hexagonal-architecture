package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.Value;

@Value
public class GraphRegisterUserRequest {
    private String email;
    private String firstName;
    private String surname;
    private String password;
    private String dateOfBirth;
}
