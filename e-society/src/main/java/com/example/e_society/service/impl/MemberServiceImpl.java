package com.example.e_society.service.impl;

import com.example.e_society.model.Flat;
import com.example.e_society.model.Member;
import com.example.e_society.repository.FlatRepository;
import com.example.e_society.repository.MemberRepository;
import com.example.e_society.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FlatRepository flatRepository;

   
    public Member saveMember(Member member, int flatId) {
        Flat flat = flatRepository.findById(flatId)
                .orElseThrow(() -> new RuntimeException("Flat not found id=" + flatId));
        member.setFlat(flat);          // ⭐ critical
        return memberRepository.save(member);
    }


    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> getMemberById(int id) {
        return memberRepository.findById(id);
    }

    @Override
    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }
}
