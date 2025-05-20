package com.example.e_society.config;

import com.example.e_society.model.User;
import com.example.e_society.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SampleDataLoader {

    @Bean
    CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin1").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin1");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
            }

            if (userRepository.findByUsername("user1").isEmpty()) {
                User user = new User();
                user.setUsername("user1");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRole("ROLE_USER");
                userRepository.save(user);
            }

            System.out.println("✅ Sample users loaded.");
        };
    }
}
