package com.example.e_society.controller;

import com.example.e_society.model.User;
import com.example.e_society.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Add "ROLE_" prefix if not already present
        if (!user.getRole().startsWith("ROLE_")) {
            user.setRole("ROLE_" + user.getRole());
        }

        userRepository.save(user);
        return "User registered successfully!";
    }
}
