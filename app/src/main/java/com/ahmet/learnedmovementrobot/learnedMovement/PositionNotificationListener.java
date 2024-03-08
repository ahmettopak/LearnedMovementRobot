package com.ahmet.learnedmovementrobot.learnedMovement;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 3/8/2024
 */

public interface PositionNotificationListener {

    // Enum to specify notification types
    enum NotificationType {
        SUCCESS,
        ERROR,
        WARNING,
        INFO
    }

    /**
     * Used for position notifications.
     * @param message Notification message
     * @param type Notification type
     */
    void notify(String message, NotificationType type);

    /**
     * Used for position notifications and handles possible exceptions.
     * @param message Notification message
     * @param type Notification type
     * @param exception The exception (error) occurred
     */
    void notifyWithException(String message, NotificationType type, Exception exception);
}