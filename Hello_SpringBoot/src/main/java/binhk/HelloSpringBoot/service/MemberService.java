package binhk.HelloSpringBoot.service;

import binhk.HelloSpringBoot.domain.Member;
import binhk.HelloSpringBoot.repository.MemberRepository;
import binhk.HelloSpringBoot.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
        //중복허용 안함
        vaildateDuplicateMemer(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMemer(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalArgumentException("이미 존재하는 회원 입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
