package org.example.ex06;

import org.example.ex06.member.controller.MemberController;
import org.example.ex06.member.entity.Member;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex06ApplicationTests {

    @Autowired
    MemberController memberController;

    @BeforeAll
    static void beforeAll() {
        System.out.println("전체 테스트 시작");
    }

    @BeforeEach
    void setUp() {
        System.out.println("테스트 시작");
    }

    @Test
    @DisplayName("테스트 메서드")
    void testMethod(){
        System.out.println("테스트 메서드");
    }

    @AfterEach
    void tearDown(){
        System.out.println("테스트 종료");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("전체 테스트 종료");
    }
}
