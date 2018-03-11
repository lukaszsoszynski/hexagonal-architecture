package com.impaqgroup.training.architecture.hexagonalarchitecture.notification.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.NotificationSender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
class AmqpNotificationSender implements NotificationSender {

    private static final String FORUM_EXCHANGE = "forum";
    private final RabbitTemplate rabbitTemplate;
    private final ConversionService conversionService;

    /*
    Queue e.q. hexagonal-architecture-forum-queue
     */
    @Override
    public void sendNotification(ForumNotification forumNotification){
        Assert.notNull(forumNotification, "Notification is required.");
        String routingKey = routingKeyForNotification(forumNotification);
        onTransactionSuccessfullyCommitted(() -> sendNotification(forumNotification, routingKey));
    }

    private String routingKeyForNotification(ForumNotification notification) {
        return String.format("forum.action.%s", notification.getType().name().toLowerCase().replace("_", "."));
    }

    private void sendNotification(ForumNotification notification, String routingKey) {
        AmqpForumNotificationDto amqpForumNotificationDto = conversionService.convert(notification, AmqpForumNotificationDto.class);
        log.info("Send notification '{}' with routing key '{}'.", amqpForumNotificationDto, routingKey);
        rabbitTemplate.convertAndSend(FORUM_EXCHANGE, routingKey, amqpForumNotificationDto);
    }

    private void onTransactionSuccessfullyCommitted(Runnable runnableAfterTransactionCommitted) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                runnableAfterTransactionCommitted.run();
            }
        });
    }
}
