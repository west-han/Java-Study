package advanced2.io.member.impl;

import advanced2.io.member.Member;
import advanced2.io.member.MemberRepository;

import java.util.List;

public class MemoryMemberRepository implements MemberRepository {

    List<Member> members;

    public MemoryMemberRepository(List<Member> members) {
        this.members = members;
    }

    @Override
    public void add(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return members;
    }
}
