package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Value
public class GraphUserDto {
    private String email;
    private String firstName;
    private String lastName;
    private String registeredDate;
    private String dateOfBirth;
    @Getter(AccessLevel.NONE)
    private Stream<GraphThreadDto> createdThreads;
    @Getter(AccessLevel.NONE)
    private Stream<GraphPostDto> authorOfPosts;

    public List<GraphThreadDto> getCreatedThreads(){
        return createdThreads.collect(toList());
    }

    public List<GraphPostDto> getAuthorOfPosts(){
        return authorOfPosts.collect(toList());
    }
}
