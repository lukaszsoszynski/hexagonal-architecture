package com.impaqgroup.training.architecture.hexagonalarchitecture.notification;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
class AmqpNotificationSender implements NotificationSender{

    private static final String FORUM_EXCHANGE = "forum";
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendNotification(ForumNotification notification){
        Assert.notNull(notification, "Notification is required.");
        String routingKey = String.format("forum.action.%s", notification.getType().name().toLowerCase().replace("_", "."));
        rabbitTemplate.convertAndSend(FORUM_EXCHANGE, routingKey, notification);
    }
}
