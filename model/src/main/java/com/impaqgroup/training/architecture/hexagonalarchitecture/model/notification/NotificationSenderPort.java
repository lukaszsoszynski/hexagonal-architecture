package com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.InputPort;

@InputPort
public interface NotificationSenderPort {

    void sendNotification(ForumNotification notification);
}
