package com.example.e_society.dto;

public class JwtResponse {

    private String token;

    // Default constructor
    public JwtResponse() {
    }

    // Constructor with token
    public JwtResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter
    public void setToken(String token) {
        this.token = token;
    }

    // Optional: toString method for logging/debugging
    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
