package com.impaqgroup.training.architecture.hexagonalarchitecture.notification.amqpsecondaryadapter;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.NotificationSenderPort;
import com.impaqgroup.training.architecture.hexagonalarchitecture.notification.amqp.AmqpForumNotificationDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.notification.amqp.AmqpNotificationSender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
class NotificationSenderToAmqpNotificationSenderSecondaryAdapter implements NotificationSenderPort {

    private final AmqpNotificationSender amqpNotificationSender;
    private final ConversionService conversionService;

    /*
    Queue e.q. hexagonal-architecture-forum-queue
     */
    @Override
    public void sendNotification(ForumNotification forumNotification){
        Assert.notNull(forumNotification, "Notification is required.");
        AmqpForumNotificationDto amqpForumNotificationDto = conversionService.convert(forumNotification, AmqpForumNotificationDto.class);
        amqpNotificationSender.sendNotification(amqpForumNotificationDto, forumNotification.getType().name());
    }
}
