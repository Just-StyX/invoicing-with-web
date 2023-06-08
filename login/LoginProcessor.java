package com.jbdev.orderapp.login;

import com.jbdev.orderapp.models.User;
import com.jbdev.orderapp.services.LoggedUserManagerServices;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagerServices loggedUserManagerServices;

    public LoginProcessor(LoggedUserManagerServices loggedUserManagerServices) {
        this.loggedUserManagerServices = loggedUserManagerServices;
    }

    public boolean login(User user) {
        boolean loggedInResult = false;
        if("Username".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            loggedInResult = true;
            loggedUserManagerServices.setUsername(user.getUsername());
            loggedUserManagerServices.setEmail(user.getEmail());
        }
        return loggedInResult;
    }
}
