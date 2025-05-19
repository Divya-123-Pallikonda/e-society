package com.example.e_society.repository;

import com.example.e_society.model.Society;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // This annotation is optional but recommended
public interface SocietyRepository extends JpaRepository<Society, Integer> {
    // No need to write methods unless you want custom queries
}
