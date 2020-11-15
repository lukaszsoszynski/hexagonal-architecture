package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static lombok.AccessLevel.NONE;

@Value
public class GraphThreadDto {
    private final Long threadId;
    private final String threadName;

    @Getter(NONE)
    private final Supplier<GraphUserDto> creator;

    @Getter(NONE)
    private final Supplier<GraphForumDto>  subForum;

    @Getter(NONE)
    @ToString.Exclude
    private Stream<GraphPostDto> posts;

    public String getCreatorEmail(){
        return creator.get().getEmail();
    }

    public GraphUserDto getCreator() {
        return creator.get();
    }

    public GraphForumDto getSubForum() {
        return subForum.get();
    }

    public List<GraphPostDto> getPosts(){
        return posts.collect(toList());
    }

    public List<GraphPostDto> recentPosts(int numberOfPosts) {
        return posts.limit(numberOfPosts).collect(toUnmodifiableList());
    }
}
