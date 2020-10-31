package com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto;

import lombok.Value;
import lombok.With;

@Value
public class PostDto {

    @With
    private Long postId;

    private String title;

    private String content;

    public boolean isUserIdPresent(){
        return postId != null;
    }
}
