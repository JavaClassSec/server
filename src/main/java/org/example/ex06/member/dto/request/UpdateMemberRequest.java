package org.example.ex06.member.dto.request;

public record UpdateMemberRequest(
        Long id,
        String name,
        String email
) {
}
