package com.example.e_society.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public String hello() {
        return "Swagger is working!";
    }
}
