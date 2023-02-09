package com.ddddrecipe.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("member DB저장")
    void saveMember() {
        //given
        Member testMember = Member
                .builder()
                .nickname("test_name")
                .email("test@email.com")
                .password("test_password")
                .role(Role.ROLE_MEMBER)
                .enabled(true)
                .build();
        //when
        Member savedMember = memberRepository.save(testMember);
        //then
        assertThat(savedMember).isEqualTo(testMember);
    }

    @Test
    @DisplayName("member DB조회")
    void findMember() {
        //given
        Member testMember = Member
                .builder()
                .nickname("test_name")
                .email("test@email.com")
                .password("test_password")
                .role(Role.ROLE_MEMBER)
                .enabled(true)
                .build();
        Member savedMember = memberRepository.save(testMember);
        //when
        Member findMember = (memberRepository.findById(savedMember.getId())).orElseThrow(RuntimeException::new);
        //then
        assertThat(findMember).isEqualTo(savedMember);
    }
}