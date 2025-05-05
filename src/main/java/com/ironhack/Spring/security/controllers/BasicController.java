package com.ironhack.Spring.security.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BasicController {
    @GetMapping("/cosas-importantes")
    public ResponseEntity<String> cosasImportantes(){
        return ResponseEntity.ok("Toma, esto es lo importante que querías");
    }

    @GetMapping("/public/users")
    public ResponseEntity<String> publicUsers(){
        return ResponseEntity.ok("Esta es la info pública");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> adminRoute(){
        return ResponseEntity.ok("La ruta de admin es toda tuya");
    }

}
