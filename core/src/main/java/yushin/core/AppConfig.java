package yushin.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yushin.core.discount.DiscountPolicy;
import yushin.core.discount.FixDiscountPolicy;
import yushin.core.discount.RateDiscountPolicy;
import yushin.core.member.MemberRepository;
import yushin.core.member.MemberService;
import yushin.core.member.MemberServiceImpl;
import yushin.core.member.MemoryMemberRepository;
import yushin.core.order.OrderService;
import yushin.core.order.OrderServiceImpl;

// 객체의 생성과 연결을 담당한다.
// factory method를 이용해 등록하는 방법이다.
@Configuration  // 싱글톤 컨테이너를 생성해주는 애노테이션
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService has been called.");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository has been called.");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService has been called.");
        //return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 할인 정책을 바꿀 때는 아래 두 줄만 스왑하면 된다. 따라서 OCP, DIP를 철저히 만족하게 된다.
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
