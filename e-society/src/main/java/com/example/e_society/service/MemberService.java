package com.example.e_society.service;

import com.example.e_society.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member saveMember(Member member, int flatId);
    List<Member> getAllMembers();
    Optional<Member> getMemberById(int id);
    void deleteMember(int id);
}

