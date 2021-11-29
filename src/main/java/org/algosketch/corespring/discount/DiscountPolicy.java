package org.algosketch.corespring.discount;

import org.algosketch.corespring.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인되는 금액
     */
    int discount(Member member, int price);
}
