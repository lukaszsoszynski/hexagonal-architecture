package com.impaqgroup.training.architecture.hexagonalarchitecture.service.notification;

public enum ActionType {
    POST_ADDED, POST_UPDATED, POST_REMOVED;

    String routingName() {
        return name().toLowerCase().replace("_", ".");
    }
}
