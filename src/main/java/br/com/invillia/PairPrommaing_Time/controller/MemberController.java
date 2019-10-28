package br.com.invillia.PairPrommaing_Time.controller;

import br.com.invillia.PairPrommaing_Time.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String findAll(Model model){
        model.addAttribute("members",memberService.findAll());

        return "ListarMembers";
    }
}
