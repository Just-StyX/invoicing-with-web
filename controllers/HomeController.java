package com.jbdev.orderapp.controllers;

import com.jbdev.orderapp.login.LoginProcessor;
import com.jbdev.orderapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final LoginProcessor loginProcessor;

    public HomeController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginPost(
            Model model,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email
    ) {
        User user = new User(username, password, email);
        if(loginProcessor.login(user)) {
            return "redirect:/invoice";
        }
        model.addAttribute("message", "Incorrect Credentials");
        return "login";
    }
}
