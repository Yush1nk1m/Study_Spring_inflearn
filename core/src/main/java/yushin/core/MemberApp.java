package yushin.core;

import yushin.core.member.Grade;
import yushin.core.member.Member;
import yushin.core.member.MemberService;
import yushin.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("found member = " + findMember.getName());
    }
}
