package yushin.core.order;

import yushin.core.discount.DiscountPolicy;
import yushin.core.discount.FixDiscountPolicy;
import yushin.core.member.Member;
import yushin.core.member.MemberRepository;
import yushin.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // SRP(단일 책임 원칙)가 잘 지켜진 예시이다. 할인 정책에 변경점이 있어도 받는 영향이 적다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
