package com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification;

public enum ActionType {
    POST_ADDED(true), POST_UPDATED(true), POST_REMOVED(true), THREAD_COMMENCED(false);

    private final boolean relatedToPost;

    ActionType(boolean relatedToPost) {
        this.relatedToPost = relatedToPost;
    }

    public boolean isRelatedToPost() {
        return relatedToPost;
    }
}
