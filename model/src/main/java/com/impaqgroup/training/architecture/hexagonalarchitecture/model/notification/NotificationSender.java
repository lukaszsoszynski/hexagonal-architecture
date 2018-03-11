package com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.InputPort;

@InputPort
public interface NotificationSender {

    void sendNotification(ForumNotification notification);
}
