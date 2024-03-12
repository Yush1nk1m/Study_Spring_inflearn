package yushin.core.member;

public class MemberServiceImpl implements MemberService {
    // 추상화와 구체화 둘 다에 의존하고 있다. 즉, DIP를 위반하고 있는 코드이다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
