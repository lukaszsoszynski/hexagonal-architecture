package com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto;

import lombok.Value;

@Value
public class RestCommenceThreadDto {

    private String threadName;
    private RestPostDto post;
}
