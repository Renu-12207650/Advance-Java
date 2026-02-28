package com.lpu.respository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lpu.model.Member;

@Repository
public class MemberRepository {

    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }

    public Member findMemberById(Long id) {
        return members.stream()
                .filter(member -> ( member).getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}