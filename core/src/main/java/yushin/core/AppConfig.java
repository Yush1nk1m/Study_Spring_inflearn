package yushin.core;

import yushin.core.discount.FixDiscountPolicy;
import yushin.core.member.MemberService;
import yushin.core.member.MemberServiceImpl;
import yushin.core.member.MemoryMemberRepository;
import yushin.core.order.OrderService;
import yushin.core.order.OrderServiceImpl;

// 객체의 생성과 연결을 담당한다.
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
