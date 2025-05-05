package com.ironhack.Spring.security.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/users")
    public String listUsers() {
        return "User listing (only accessible by administrators)";
    }
}
