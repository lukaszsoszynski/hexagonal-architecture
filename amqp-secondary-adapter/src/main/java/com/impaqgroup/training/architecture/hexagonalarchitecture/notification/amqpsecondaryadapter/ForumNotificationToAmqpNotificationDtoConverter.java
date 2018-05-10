package com.impaqgroup.training.architecture.hexagonalarchitecture.notification.amqpsecondaryadapter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification;
import com.impaqgroup.training.architecture.hexagonalarchitecture.notification.amqp.AmqpForumNotificationDto;

@Component
class ForumNotificationToAmqpNotificationDtoConverter implements Converter<ForumNotification, AmqpForumNotificationDto>{

    @Override
    public AmqpForumNotificationDto convert(ForumNotification forumNotification) {
        return new AmqpForumNotificationDto(forumNotification.getForumName());
    }
}
