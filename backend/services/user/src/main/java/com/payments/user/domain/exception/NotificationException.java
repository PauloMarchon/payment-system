package com.payments.user.domain.exception;

import com.payments.user.domain.validation.Notification;

public class NotificationException extends DomainException {
    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }
}