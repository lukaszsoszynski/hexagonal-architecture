package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.subscriptions;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphPostNotificationService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostNotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
class NewPostInThreadResolver implements GraphQLSubscriptionResolver {

    private final GraphPostNotificationService graphPostNotificationService;


    public Publisher<GraphPostNotificationDto> newPostInThread(String forumName, Long threadId) {
        return graphPostNotificationService.newPostNotifications(forumName, threadId);
    }
}
