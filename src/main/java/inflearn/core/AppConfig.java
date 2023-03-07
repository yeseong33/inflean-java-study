package inflearn.core;

import inflearn.core.discount.DiscountPolicy;
import inflearn.core.discount.FixDiscountPolicy;
import inflearn.core.discount.RateDiscountPolicy;
import inflearn.core.member.MemberRepository;
import inflearn.core.member.MemberService;
import inflearn.core.member.MemberServiceImpl;
import inflearn.core.member.MemoryMemberRepository;
import inflearn.core.order.OrderServeice;
import inflearn.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * 생성자 주입
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderServeice orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
