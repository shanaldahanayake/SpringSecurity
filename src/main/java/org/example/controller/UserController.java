package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Users;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return userService.register(users);
    }
    @PostMapping("/log")
    public String login(@RequestBody Users users){
        return userService.verify(users);
    }
}
