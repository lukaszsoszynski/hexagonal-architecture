package com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import lombok.With;

@Value
public class RestPostDto {

    @With
    private Long postId;

    private String title;

    private String content;

    private String author;

    private Long threadId;

    @JsonIgnore
    public boolean isUserIdPresent(){
        return postId != null;
    }
}
