package org.example.ex06.member.dto.response;

public record MemberResponse(
        String name,
        String email
) {
    public static MemberResponse of(MemberResponse memberResponse) {
        return new MemberResponse(
                memberResponse.name(),
                memberResponse.email()
        );
    }
}
