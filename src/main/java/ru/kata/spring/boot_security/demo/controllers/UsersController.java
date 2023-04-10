package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String userPage(Authentication authentication, Model model) {
        String name = authentication.getName();
        model.addAttribute("user", userService.findByName(name));
        return "user";
    }

    @GetMapping("/index")
    public String show() {
        return "index";
    }

}
