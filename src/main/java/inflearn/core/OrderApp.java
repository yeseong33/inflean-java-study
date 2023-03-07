package inflearn.core;

import inflearn.core.member.Grade;
import inflearn.core.member.Member;
import inflearn.core.member.MemberService;
import inflearn.core.member.MemberServiceImpl;
import inflearn.core.order.Order;
import inflearn.core.order.OrderServeice;
import inflearn.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        OrderServeice orderServeice = appConfig.orderServeice();
//        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderServeice orderServeice = new OrderServiceImpl();


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderServeice orderService = applicationContext.getBean("orderService", OrderServeice.class);

        Long memberId = 1l;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
