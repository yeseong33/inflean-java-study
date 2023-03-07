package inflearn.core.discount;

import inflearn.core.member.Grade;
import inflearn.core.member.Member;
import inflearn.core.member.MemberRepository;
import inflearn.core.member.MemoryMemberRepository;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;
    MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return price * discountPercent / 200;
        }

    }
}
