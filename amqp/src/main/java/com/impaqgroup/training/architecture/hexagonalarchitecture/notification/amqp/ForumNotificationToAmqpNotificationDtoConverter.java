package com.impaqgroup.training.architecture.hexagonalarchitecture.notification.amqp;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification;

@Component
class ForumNotificationToAmqpNotificationDtoConverter implements Converter<ForumNotification, AmqpForumNotificationDto>{

    @Override
    public AmqpForumNotificationDto convert(ForumNotification forumNotification) {
        return new AmqpForumNotificationDto(forumNotification.getForumName());
    }
}
