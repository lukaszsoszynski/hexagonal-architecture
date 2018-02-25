package com.impaqgroup.training.architecture.hexagonalarchitecture.service.notification;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NotificationSender {

    private static final String FORUM_EXCHANGE = "forum";
    private final RabbitTemplate rabbitTemplate;

    public void sendNotification(ForumNotification notification){
        Assert.notNull(notification, "Notification is required.");
        String routingKey = String.format("forum.action.%s", notification.routing());
        rabbitTemplate.convertAndSend(FORUM_EXCHANGE, routingKey, notification);
    }
}
