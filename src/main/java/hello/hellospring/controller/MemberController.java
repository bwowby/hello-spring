package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//Controller 어노테이션을 보고 컨테이너가 인스턴스 생성해서 관리한다
@Controller
public class MemberController {
    private final MemberService memberService;

    //필드 주입 방법: 생성자가 없기떄문에 객체를 뭔가 바꿔치기 하거나 해줄 수가 없음
    //@Autowired private MemberService memberService;

    //setter 주입 방법: public 으로 노출되어야 하기 때문에 처음 만들어진 이후에도 바꿀 수 있어 중간에 잘못 바뀌면 문제가 생김
    /*
    @Autowired
    public void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }
    */
    
    //Autowired 어노테이션을 보고 멤버 서비스 객체를 연결 시켜준다. 생성자 주입이 요즘 권장 스타일
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String memberForm(MemberForm form){

        System.out.println(form.getAge());
        Member member = new Member();
        member.setName(form.getNameeee());
        System.out.println(form.getNameeee());
        memberService.join(member);

        //홈 화면으로 보내기기
       return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
