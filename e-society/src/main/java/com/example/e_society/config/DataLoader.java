package com.example.e_society.config;

import com.example.e_society.repository.SocietyRepository;
import com.example.e_society.repository.FlatRepository;
import com.example.e_society.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.e_society.model.Society;
import com.example.e_society.model.Flat;
import com.example.e_society.model.Member;



@Component
public class DataLoader implements CommandLineRunner {

    private final SocietyRepository societyRepo;
    private final FlatRepository flatRepo;
    private final MemberRepository memberRepo;

    public DataLoader(SocietyRepository societyRepo, FlatRepository flatRepo, MemberRepository memberRepo) {
        this.societyRepo = societyRepo;
        this.flatRepo = flatRepo;
        this.memberRepo = memberRepo;
    }

    @Override
    public void run(String... args) {
        Society society = new Society();
        society.setName("Sunshine Residency");
        society.setAddress("Main Road, Pune");
        society = societyRepo.save(society);

        Flat flat = new Flat();
        flat.setNumber("A101");
        flat.setSociety(society);
        flat = flatRepo.save(flat);

        Member member = new Member();
        member.setName("Divya Pallikonda");
        member.setEmail("divya@example.com");
        member.setPhone("9876543210");
        member.setFlat(flat);
        memberRepo.save(member);

        
        System.out.println("✅ Sample data inserted!");
    }
}
