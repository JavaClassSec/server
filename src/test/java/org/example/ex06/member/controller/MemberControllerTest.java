package org.example.ex06.member.controller;

import org.example.ex06.member.entity.Member;
import org.example.ex06.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@SpringBootTest
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        System.out.println("테스트 시작");
    }

    @AfterEach
    void tearDown() {
        System.out.println("테스트 종료");
    }

    @Test
    void getMembers() throws Exception {

        memberRepository.save(
                new Member(
                null, "김길동","a@gmail.com"
                )
        );

        memberRepository.save(
                new Member(
                null,"이길동","b@gmail.com"
                )
        );

        mockMvc.perform(get("/member"));
    }

    @Test
    void getMember() {
    }

    @Test
    void createMember() {
        Member member = new Member(
                null,"김길동","a@gmail.com"
        );

        memberRepository.save(member);
    }

    @Test
    void deleteMember() {
    }

    @Test
    void updateMember() {
    }

    @Test
    void updateMember2() {
    }
}