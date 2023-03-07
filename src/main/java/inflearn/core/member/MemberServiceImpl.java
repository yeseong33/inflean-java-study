package inflearn.core.member;

public class MemberServiceImpl implements MemberService {

    /**
     * 이 부분에서 구현체가 추상화에도 의존하고, 구현체에도 의존하고 있다. --> DIP 위반
     * 수정 --> appconfig 에서 memberRepository를 생성해 주입해 주어 의존을 인터페이스에만 하게 만듦
     */
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
