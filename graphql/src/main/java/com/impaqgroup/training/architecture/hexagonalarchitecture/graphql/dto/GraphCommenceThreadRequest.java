package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.Value;

@Value
public class GraphCommenceThreadRequest {
    private final String forumName;
    private final String threadName;
    private final String postTitle;
    private final String postContent;
}
