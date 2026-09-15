package org.example.ex06.member.service;

import org.example.ex06.member.dto.request.PostMemberRequest;
import org.example.ex06.member.dto.request.UpdateMemberRequest;
import org.example.ex06.member.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> getMembers();

    Member getMember(Long id);

    Member postMember(PostMemberRequest request);

    void deleteMember(Long id);

    Member updateMember(UpdateMemberRequest request);
}
