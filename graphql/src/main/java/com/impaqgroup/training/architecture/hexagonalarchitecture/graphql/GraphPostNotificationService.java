package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostNotificationDto;
import org.reactivestreams.Publisher;

public interface GraphPostNotificationService {
    Publisher<GraphPostNotificationDto> newPostNotifications(String forumName, Long threadId);
}
