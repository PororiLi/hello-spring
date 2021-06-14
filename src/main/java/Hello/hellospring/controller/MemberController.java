package Hello.hellospring.controller;

import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    @Autowired private final MemberService memberService;   //필드 주입.

    private final MemberService memberService;   //필드 주입.

    @Autowired //멤버 서비스를 스프링 컨테이너의 멤버 서비스를 자동적으로 가져옴. 스프링 빈 생성. 생성자 주입.
    public MemberController(MemberService memberService) {  //해당 서비스구현체에 서비스 어노테이션 달아주면 스프링이 연결 해줌.
        this.memberService = memberService;
    }

//    @Autowired //Setter 주입
//    public void setMemberController(MemberService memberService) {  //해당 서비스구현체에 서비스 어노테이션 달아주면 스프링이 연결 해줌.
//        this.memberService = memberService;
//    }
}
