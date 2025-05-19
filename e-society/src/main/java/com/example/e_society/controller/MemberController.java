package com.example.e_society.controller;

import com.example.e_society.exception.ResourceNotFoundException;
import com.example.e_society.model.Member;
import com.example.e_society.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /* ---------- CREATE ---------- */
    @PostMapping("/flat/{flatId}")
    public ResponseEntity<Member> createMember(@PathVariable int flatId,
                                               @RequestBody Member member) {
        return ResponseEntity.ok(memberService.saveMember(member, flatId));
    }

    /* ---------- READ ALL ---------- */
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    /* ---------- READ ONE (with Exception Handling) ---------- */
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        Member member = memberService.getMemberById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));
        return ResponseEntity.ok(member);
    }

    /* ---------- UPDATE ---------- */
    @PutMapping("/{memberId}/flat/{flatId}")
    public ResponseEntity<Member> updateMember(@PathVariable int memberId,
                                               @PathVariable int flatId,
                                               @RequestBody Member body) {
        Optional<Member> opt = memberService.getMemberById(memberId);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        Member existing = opt.get();
        existing.setName(body.getName());
        existing.setEmail(body.getEmail());
        existing.setPhone(body.getPhone());

        return ResponseEntity.ok(memberService.saveMember(existing, flatId));
    }

    /* ---------- DELETE ---------- */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
