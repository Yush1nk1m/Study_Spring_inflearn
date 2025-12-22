package jpabook.jpashop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        // given
        Member member = new Member();
        member.setUsername("Yushin");

        // when
        Long memberId = memberRepository.save(member);
        Member foundMember = memberRepository.find(memberId);

        // then
        Assertions.assertEquals(member.getId(), foundMember.getId());
        Assertions.assertEquals(member.getUsername(), foundMember.getUsername());
        Assertions.assertEquals(member, foundMember);
    }
}