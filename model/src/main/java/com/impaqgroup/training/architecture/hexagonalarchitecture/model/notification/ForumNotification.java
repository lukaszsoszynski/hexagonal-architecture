package com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

@Value
@RequiredArgsConstructor(access = PRIVATE)
public class ForumNotification {

    @NonNull
    private String forumName;

    private Long threadId;

    private String title;

    @NonNull
    private ActionType type;

    public static ForumNotification postAdded(String forumName, Long threadId, String title){
        return create(forumName, threadId, title, ActionType.POST_ADDED);
    }

    public static ForumNotification postUpdated(String forumName, Long threadId, String title){
        return create(forumName, threadId, title, ActionType.POST_UPDATED);
    }

    public static ForumNotification postRemoved(String forumName, Long threadId){
        return create(forumName, threadId, null, ActionType.POST_REMOVED);
    }

    public static ForumNotification threadCommenced(String forumName, String title){
        return create(forumName, null, title, ActionType.THREAD_COMMENCED);
    }

    private static ForumNotification create(String forumName, Long threadId, String title, ActionType actionType) {
        return new ForumNotification(forumName, threadId, title, actionType);
    }

    public boolean isRelatedToPost(){
        return type.isRelatedToPost();
    }

    public boolean containsForumName(String name) {
        return requireNonNull(name, "Forum name must not be null").equals(name);
    }

    public boolean containsThreadId(Long threadId) {
        return requireNonNull(threadId, "Thread id must not be null.").equals(this.threadId);
    }
}
