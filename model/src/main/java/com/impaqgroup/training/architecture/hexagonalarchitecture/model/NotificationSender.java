package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.NotificationSenderPort;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.Brick;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;

@Brick
class NotificationSender {

    private final static Logger LOGGER = Logger.getLogger("com.impaqgroup.training.architecture.hexagonalarchitecture.model.NotificationSender");

    private final List<NotificationSenderPort> ports;

    NotificationSender(List<NotificationSenderPort> ports){
        this.ports = unmodifiableList(requireNonNull(ports, "List of NotificationSenderPort must not be null"));
    }

    public void sendNotification(ForumNotification notification) {
        ports.forEach(port -> sendNotificationViaPort(notification, port));
    }

    private void sendNotificationViaPort(ForumNotification notification, NotificationSenderPort port) {
        try {
            port.sendNotification(notification);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred during sending notification: " + notification);
        }
    }
}
