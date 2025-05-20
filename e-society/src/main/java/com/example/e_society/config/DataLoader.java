package com.example.e_society.config;

import com.example.e_society.model.Flat;
import com.example.e_society.model.Member;
import com.example.e_society.model.Society;
import com.example.e_society.model.User;
import com.example.e_society.repository.FlatRepository;
import com.example.e_society.repository.MemberRepository;
import com.example.e_society.repository.SocietyRepository;
import com.example.e_society.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final SocietyRepository societyRepo;
    private final FlatRepository flatRepo;
    private final MemberRepository memberRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(
            SocietyRepository societyRepo,
            FlatRepository flatRepo,
            MemberRepository memberRepo,
            UserRepository userRepo,
            PasswordEncoder passwordEncoder
    ) {
        this.societyRepo = societyRepo;
        this.flatRepo = flatRepo;
        this.memberRepo = memberRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (societyRepo.count() == 0) {
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

            System.out.println("✅ Sample Society, Flat, Member inserted!");
        } else {
            System.out.println("ℹ️ Society data already exists. Skipping insert.");
        }

        if (userRepo.count() == 0) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ROLE_ADMIN");
            userRepo.save(admin);

            User memberUser = new User();
            memberUser.setUsername("member");
            memberUser.setPassword(passwordEncoder.encode("member123"));
            memberUser.setRole("ROLE_MEMBER");
            userRepo.save(memberUser);

            System.out.println("✅ Sample Users inserted: admin / member");
        } else {
            System.out.println("ℹ️ User data already exists. Skipping insert.");
        }
    }
}
