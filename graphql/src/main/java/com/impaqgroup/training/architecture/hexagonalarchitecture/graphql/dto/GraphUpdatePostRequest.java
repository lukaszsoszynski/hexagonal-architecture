package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.Value;

@Value
public class GraphUpdatePostRequest {
    private String forumName;
    private Long threadId;
    private Long postId;
    private String title;
    private String content;
}
