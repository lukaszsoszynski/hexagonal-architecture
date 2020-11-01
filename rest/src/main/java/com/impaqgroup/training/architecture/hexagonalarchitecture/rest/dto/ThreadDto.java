package com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto;

import lombok.Value;

@Value
public class ThreadDto {

    private final Long threadId;
    private final String threadName;
    private final String creator;
    private final String forumName;
}
