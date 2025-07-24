package com.ntg.SpringBootDemo2.PrimaryQualifier;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notification{

    @Override
    public void sendMessage(String username) {
        System.out.println("Email Notification Send to " + username);
    }
}
