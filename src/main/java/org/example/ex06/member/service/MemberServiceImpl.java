package org.example.ex06.member.service;

import lombok.RequiredArgsConstructor;
import org.example.ex06.member.dto.request.PostMemberRequest;
import org.example.ex06.member.dto.request.UpdateMemberRequest;
import org.example.ex06.member.entity.Member;
import org.example.ex06.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.RollbackOn;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버")
        );
    }

    @Override
    public Member postMember(PostMemberRequest request) {
        Member member = Member.builder()
                .name(request.name())
                .email(request.email())
                .build();

        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member updateMember(UpdateMemberRequest request) {
        Member member = memberRepository.findById(request.id())
                .orElseThrow(
                        () -> new IllegalArgumentException("없는 멤버")
                );

        member.setName(request.name());
        member.setEmail(request.email());

        return memberRepository.save(member);
    }

}
