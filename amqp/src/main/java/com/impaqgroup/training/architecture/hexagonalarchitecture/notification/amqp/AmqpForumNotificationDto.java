package com.impaqgroup.training.architecture.hexagonalarchitecture.notification.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
class AmqpForumNotificationDto {

    @JsonProperty("forum_name")
    private String forumName;
}
