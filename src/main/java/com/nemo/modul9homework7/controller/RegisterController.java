package com.nemo.modul9homework7.controller;

import com.nemo.modul9homework7.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestParam String email, @RequestParam String profile) {
        try {
            emailService.sendActivationEmail(email, profile);
            return ResponseEntity.ok("Registration successful!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during registration");
        }
    }
}

