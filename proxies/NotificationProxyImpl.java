package com.jbdev.orderapp.proxies;


import org.springframework.stereotype.Component;

@Component
public class NotificationProxyImpl implements NotificationProxy{
    @Override
    public String sendNotification() {
        return "Thank you for shopping with us !!!";
    }
}
