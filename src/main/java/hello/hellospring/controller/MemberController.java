package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//Controller 어노테이션을 보고 컨테이너가 인스턴스 생성해서 관리한다
@Controller
public class MemberController {
    private final MemberService memberService;

    //Autowired 어노테이션을 보고 멤버 서비스 객체를 연결 시켜준다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
