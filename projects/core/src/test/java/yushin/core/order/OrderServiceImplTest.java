package yushin.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import yushin.core.discount.FixDiscountPolicy;
import yushin.core.member.Grade;
import yushin.core.member.Member;
import yushin.core.member.MemberRepository;
import yushin.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}