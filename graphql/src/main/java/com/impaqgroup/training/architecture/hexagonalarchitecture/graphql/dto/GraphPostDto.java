package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

import java.util.function.Supplier;

@Value
public class GraphPostDto {
    private Long postId;

    private String title;

    private String content;

    @Getter(AccessLevel.NONE)
    private Supplier<GraphUserDto> author;

    public String getAuthorEmail(){
        return author.get().getEmail();
    }

    public GraphUserDto getAuthor(){
        return author.get();
    }
}
