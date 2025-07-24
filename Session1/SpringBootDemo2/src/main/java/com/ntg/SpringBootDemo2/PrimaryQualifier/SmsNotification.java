package com.ntg.SpringBootDemo2.PrimaryQualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class SmsNotification implements Notification {

    @Override
    public void sendMessage(String username) {
        System.out.println("SMS Notification Send to " + username);
    }
}
