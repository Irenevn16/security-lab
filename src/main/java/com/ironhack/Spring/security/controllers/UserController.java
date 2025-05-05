package com.ironhack.Spring.security.controllers;

import com.ironhack.Spring.security.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @GetMapping("/profile")
    public String profile(Authentication authentication) {
        return "User profile: " + authentication.getName();
    }
}