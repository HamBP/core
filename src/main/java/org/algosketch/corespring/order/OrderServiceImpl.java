package org.algosketch.corespring.order;

import org.algosketch.corespring.discount.DiscountPolicy;
import org.algosketch.corespring.discount.FixDiscountPolicy;
import org.algosketch.corespring.member.Member;
import org.algosketch.corespring.member.MemberRepository;
import org.algosketch.corespring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
