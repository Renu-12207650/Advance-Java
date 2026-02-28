package com.lpu.services;


import org.springframework.stereotype.Service;
import com.lpu.respository.MemberRepository;
import com.lpu.model.Member;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private Long memberCounter = 1L;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerMember(String name, String email) {
        Member member = new Member(memberCounter++, name, email);
        memberRepository.addMember(member);
        System.out.println("Member Registered Successfully!");
    }

    public Member findMember(Long id) {
        return memberRepository.findMemberById(id);
    }
}