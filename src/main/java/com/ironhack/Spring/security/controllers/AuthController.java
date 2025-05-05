package com.ironhack.Spring.security.controllers;
import com.ironhack.Spring.security.models.AuthResponseDto;
import com.ironhack.Spring.security.models.User;
import com.ironhack.Spring.security.services.JwtService;
import com.ironhack.Spring.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> optionalUser = userService.findByUsername(user.getUsername());

        if (optionalUser.isPresent()) {
            //extraemos obj dentro de optional
            User foundUser = optionalUser.get();
            //comprobamos si la contra es correcta
            if (userService.checkPassword(foundUser, user.getPassword())) {
                List<String> roleNames = foundUser.getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toList());

                String token = jwtService.generateToken(foundUser.getUsername(), foundUser.getRoles().toString());
                AuthResponseDto response = new AuthResponseDto();
                response.setToken(token);
                response.setUsername(foundUser.getUsername());
                response.setRoles(roleNames);

                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect login");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
