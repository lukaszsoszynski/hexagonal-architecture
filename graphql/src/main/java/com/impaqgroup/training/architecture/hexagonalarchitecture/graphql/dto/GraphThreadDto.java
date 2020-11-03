package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Value
public class GraphThreadDto {
    private final Long threadId;
    private final String threadName;

    @Getter(AccessLevel.NONE)
    private final Supplier<GraphUserDto> creator;

    @Getter(AccessLevel.NONE)
    private Stream<GraphPostDto> posts;

    public String getCreatorEmail(){
        return creator.get().getEmail();
    }

    public GraphUserDto getCreator() {
        return creator.get();
    }

    public List<GraphPostDto> getPosts(){
        return posts.collect(toList());
    }
}
