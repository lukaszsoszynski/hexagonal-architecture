package com.impaqgroup.training.architecture.hexagonalarchitecture.service.notification;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ForumNotification {

    private String forumName;

    @JsonIgnore
    private ActionType type;

    public static ForumNotification postAdded(String forumName){
        return create(forumName, ActionType.POST_ADDED);
    }

    public static ForumNotification postUpdated(String forumName){
        return create(forumName, ActionType.POST_UPDATED);
    }

    public static ForumNotification postRemoved(String forumName){
        return create(forumName, ActionType.POST_REMOVED);
    }

    private static ForumNotification create(String forumName, ActionType postRemoved) {
        return new ForumNotification(forumName, postRemoved);
    }

}
