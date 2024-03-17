package yushin.core.discount;

import org.springframework.stereotype.Component;
import yushin.core.member.Grade;
import yushin.core.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
