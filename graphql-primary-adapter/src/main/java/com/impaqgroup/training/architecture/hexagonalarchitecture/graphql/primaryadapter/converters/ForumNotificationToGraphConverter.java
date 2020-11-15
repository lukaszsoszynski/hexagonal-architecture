package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostNotificationDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class ForumNotificationToGraphConverter implements Converter<ForumNotification, GraphPostNotificationDto> {
    @Override
    public GraphPostNotificationDto convert(ForumNotification source) {
        return new GraphPostNotificationDto(source.getForumName(),
                source.getThreadId(),
                source.getTitle(),
                source.getType().name());
    }
}
