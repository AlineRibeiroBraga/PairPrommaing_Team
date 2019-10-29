package br.com.invillia.PairPrommaing_Time.controller;

import br.com.invillia.PairPrommaing_Time.domain.Member;
import br.com.invillia.PairPrommaing_Time.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("members",memberService.findAll());

        return "Member/ListarMembers";
    }

    @GetMapping("/registerMember")
    public String register(@Valid Member member){
        return "Member/RegisterMember";
    }

    @PostMapping("/saveMember")
    public String save(@Valid Member member, BindingResult result, Model model){

        if(result.hasErrors()){
            return "Member/RegisterMember";
        }

        memberService.save(member);
        model.addAttribute("member",memberService.findAll());

        return "Member/ListarMembers";
    }
}
