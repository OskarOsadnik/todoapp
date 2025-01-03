package com.example.todoapp.User.Controller;

import com.example.todoapp.Model.AuthenticatedUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/greet")
public class GreetController {

    @GetMapping
    public String greet() {
        AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hi " + user.getUsername() + " you are allowed";
    }
}
