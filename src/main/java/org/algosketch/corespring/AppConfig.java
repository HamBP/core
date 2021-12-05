package org.algosketch.corespring;

import org.algosketch.corespring.discount.DiscountPolicy;
import org.algosketch.corespring.discount.RateDiscountPolicy;
import org.algosketch.corespring.member.MemberRepository;
import org.algosketch.corespring.member.MemberService;
import org.algosketch.corespring.member.MemberServiceImpl;
import org.algosketch.corespring.member.MemoryMemberRepository;
import org.algosketch.corespring.order.OrderService;
import org.algosketch.corespring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
