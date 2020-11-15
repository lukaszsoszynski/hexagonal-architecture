package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
public class GraphForumDto {
    private String name;
    private String title;
    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    private Stream<GraphThreadDto> threads;

    public List<GraphThreadDto> getThreads(){
        return threads.collect(Collectors.toList());
    }

}
