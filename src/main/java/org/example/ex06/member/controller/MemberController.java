package org.example.ex06.member.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "전체 멤버 조회" , description = "전체 멤버를 조회하는 api입니다.")
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "단일 멤버 조회", description = "멤버 상세조회하는 api입니다.")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PostMapping
    @Operation(summary = "멤버 생성", description = "멤버 생성 api입니다")
    public Member createMember(@RequestBody PostMemberRequest request) {
        return memberService.postMember(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "멤버 삭제",description = "멤버 삭제 api입니다")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @PatchMapping
    @Operation(summary = "멤버 수정", description = "멤버 수정 api입니다")
    public Member updateMember(@RequestBody UpdateMemberRequest request) {
        return memberService.updateMember(request);
    }

    @PutMapping
    @Operation(summary = "멤버 수정", description = "멤버 수정 api입니다")
    public Member updateMember2(@RequestBody UpdateMemberRequest request) { return memberService.updateMember(request); }
}
