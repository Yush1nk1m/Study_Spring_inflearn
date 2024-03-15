package yushin.core.order;

import yushin.core.member.MemberRepository;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
