package yushin.core;

import yushin.core.member.Grade;
import yushin.core.member.Member;
import yushin.core.member.MemberService;
import yushin.core.member.MemberServiceImpl;
import yushin.core.order.Order;
import yushin.core.order.OrderService;
import yushin.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
