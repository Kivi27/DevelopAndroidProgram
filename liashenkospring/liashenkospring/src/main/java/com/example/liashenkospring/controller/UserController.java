package com.example.liashenkospring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok().body("Server is work!");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Error!!!" + exception.getMessage());
        }
    }
}
