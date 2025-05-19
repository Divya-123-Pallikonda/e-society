package com.example.e_society.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_society.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
