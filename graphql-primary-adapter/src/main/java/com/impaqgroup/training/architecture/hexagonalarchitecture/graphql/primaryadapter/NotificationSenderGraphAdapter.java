package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphPostNotificationService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostNotificationDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.NotificationSenderPort;
import io.reactivex.rxjava3.subjects.PublishSubject;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import static io.reactivex.rxjava3.core.BackpressureStrategy.DROP;

@Slf4j
@Component
class NotificationSenderGraphAdapter implements GraphPostNotificationService, NotificationSenderPort {

    private final ConversionService conversionService;
    private final PublishSubject<ForumNotification> newPostPublishSubject;

    NotificationSenderGraphAdapter(ConversionService conversionService) {
        this.conversionService = conversionService;
        this.newPostPublishSubject = PublishSubject.create();
    }

    @Override
    public Publisher<GraphPostNotificationDto> newPostNotifications(String forumName, Long threadId) {
        log.info("Subscription related to notification on posts form forum '{}' in thread '{}'", forumName, threadId);
        return newPostPublishSubject
                .doOnNext(notification -> log.info("Publisher for '{}'/'{}' receive notification '{}'", forumName, threadId, notification))
                .filter(ForumNotification::isRelatedToPost)
                .filter(notification -> notification.containsForumName(forumName))
                .filter(notification -> notification.containsThreadId(threadId))
                .map(forumNotification -> conversionService.convert(forumNotification, GraphPostNotificationDto.class))
                .doOnNext(notification -> log.info("Publisher for '{}'/'{}' receive notification '{}' which will be send to client", forumName, threadId))
                .toFlowable(DROP);
    }

    @Override
    public void sendNotification(ForumNotification notification) {
        newPostPublishSubject.onNext(notification);
    }
}
