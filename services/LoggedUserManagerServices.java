package com.jbdev.orderapp.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Setter
@Getter
@Component
@SessionScope
public class LoggedUserManagerServices {
    private String username;
    private String email;
}
