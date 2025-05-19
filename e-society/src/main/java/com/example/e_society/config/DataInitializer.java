package com.example.e_society.config;

import com.example.e_society.model.Flat;
import com.example.e_society.model.Society;
import com.example.e_society.repository.FlatRepository;
import com.example.e_society.repository.SocietyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(SocietyRepository societyRepository, FlatRepository flatRepository) {
        return args -> {
            // Create and save a new Society
            Society society = new Society();
            society.setName("Green Residency");
            society.setAddress("123 Main Street");
            society.setCity("Mumbai");
            society.setName("Maharashtra");
            society.setPincode("400001");
            societyRepository.save(society);

            // Create and save a new Flat
            Flat flat = new Flat();
            flat.setNumber("A-101");
            flat.setFloor(1);
            flat.setSize(1200.0);
            flat.setSociety(society);
            flatRepository.save(flat);

            System.out.println("✅ Sample Society and Flat inserted successfully.");
        };
    }
}
