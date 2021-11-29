package org.algosketch.corespring;

import org.algosketch.corespring.discount.DiscountPolicy;
import org.algosketch.corespring.discount.RateDiscountPolicy;
import org.algosketch.corespring.member.MemberRepository;
import org.algosketch.corespring.member.MemberService;
import org.algosketch.corespring.member.MemberServiceImpl;
import org.algosketch.corespring.member.MemoryMemberRepository;
import org.algosketch.corespring.order.OrderService;
import org.algosketch.corespring.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService;
    public OrderService orderService;

    public AppConfig() {
        this.memberService = new MemberServiceImpl(memberRepository());
        this.orderService = new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
