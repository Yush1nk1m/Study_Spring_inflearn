package yushin.core.member;

public class MemberServiceImpl implements MemberService {
    // 생성자를 통해 MemberRepository를 주입한다(생성자 주입).
    // MemberServiceImpl은 이제 추상화에만 의존하게 되었다.
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

    // Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
