package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import lombok.Value;

@Value
public class GraphPostNotificationDto {
    private String forumName;
    private Long threadId;
    private String title;
    private String action;
}
