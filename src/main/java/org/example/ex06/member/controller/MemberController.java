package org.example.ex06.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.ex06.member.dto.request.PostMemberRequest;
import org.example.ex06.member.dto.request.UpdateMemberRequest;
import org.example.ex06.member.entity.Member;
import org.example.ex06.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PostMapping
    public Member createMember(@RequestBody PostMemberRequest request) {
        return memberService.postMember(request);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @PatchMapping
    public Member updateMember(@RequestBody UpdateMemberRequest request) {
        return memberService.updateMember(request);
    }
}
