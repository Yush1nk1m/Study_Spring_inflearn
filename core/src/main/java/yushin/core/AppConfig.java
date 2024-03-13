package yushin.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yushin.core.discount.DiscountPolicy;
import yushin.core.discount.FixDiscountPolicy;
import yushin.core.discount.RateDiscountPolicy;
import yushin.core.member.MemberService;
import yushin.core.member.MemberServiceImpl;
import yushin.core.member.MemoryMemberRepository;
import yushin.core.order.OrderService;
import yushin.core.order.OrderServiceImpl;

// 객체의 생성과 연결을 담당한다.
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 할인 정책을 바꿀 때는 아래 두 줄만 스왑하면 된다. 따라서 OCP, DIP를 철저히 만족하게 된다.
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
