package org.algosketch.corespring;

import org.algosketch.corespring.member.Grade;
import org.algosketch.corespring.member.Member;
import org.algosketch.corespring.member.MemberService;
import org.algosketch.corespring.member.MemberServiceImpl;
import org.algosketch.corespring.order.Order;
import org.algosketch.corespring.order.OrderService;
import org.algosketch.corespring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order calculate " + order.calculatePrice());
    }
}
