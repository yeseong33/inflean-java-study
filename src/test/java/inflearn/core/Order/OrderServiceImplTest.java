package inflearn.core.Order;

import inflearn.core.AppConfig;
import inflearn.core.member.Grade;
import inflearn.core.member.Member;
import inflearn.core.member.MemberService;
import inflearn.core.member.MemberServiceImpl;
import inflearn.core.order.Order;
import inflearn.core.order.OrderServeice;
import inflearn.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {
    MemberService memberService;
    OrderServeice orderServeice;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderServeice = appConfig.orderService();
    }

    @Test()
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderServeice.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
