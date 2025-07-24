package com.ntg.SpringBootDemo2.PrimaryQualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

//    @Autowired
    Notification notification;

    public NotificationService(@Qualifier("smsNotification") @Autowired Notification notification) {
        this.notification = notification;
    }

    public void sendMessage(String username) {
        notification.sendMessage(username);
    }
}
