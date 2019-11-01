package br.com.invillia.PairPrommaing_Time.controller;

import br.com.invillia.PairPrommaing_Time.domain.Member;
import br.com.invillia.PairPrommaing_Time.domain.Team;
import br.com.invillia.PairPrommaing_Time.service.MemberService;
import br.com.invillia.PairPrommaing_Time.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final TeamService teamService;

    @Autowired
    public MemberController(MemberService memberService, TeamService teamService) {
        this.memberService = memberService;
        this.teamService = teamService;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("members",memberService.findAll());

        return "Member/ListMembers";
    }

    @GetMapping("/registerMember")
    public String register(Member member, Model model){

        List<Team> teams = teamService.findAll();

        if(!teams.isEmpty()){
            model.addAttribute("teams",teams);
            return "Member/RegisterMember";
        }

        return "Member/Error";
    }

    @PostMapping("/saveMember")
    public String save(@Valid Member member, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("teams", teamService.findAll());
            return "Member/RegisterMember";
        }

        memberService.save(member);
        return "redirect:/member/";
    }


    @GetMapping("/editMember/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Member member = memberService.findById(id);
        List<Team> teams = teamService.findAll();

        model.addAttribute("member",member);
        model.addAttribute("teams",teams);

        return "Member/UpdateMember";
    }

    @PostMapping("/updateMember/{id}")
    public String upDate(@PathVariable("id") long id, @Valid Member member, BindingResult result, Model model){

        if(result.hasErrors()){
            member.setId(id);
            model.addAttribute("teams", teamService.findAll());
            return "Member/UpdateMember";
        }

        memberService.update(member);
        return "redirect:/member/";
    }

    @GetMapping("/deleteMember/{id}")
    public String delete(@PathVariable("id") long id, Model model){

        memberService.delete(memberService.findById(id));

        return "redirect:/member/";

    }

    @GetMapping("/searchMember")
    public String searchMember(@RequestParam("searchTerm") String searchTerm,
                               @RequestParam("searchType") String searchType, Model model){

        switch(searchType){
            case "Id":
                try{
                    model.addAttribute("members",memberService.findAllById(Long.valueOf(searchTerm)));
                }
                catch(Exception e ){
                    model.addAttribute("members",new ArrayList<Member>());
                }
                break;
            case "Team":
                model.addAttribute("members",memberService.findByTeamNameContainingIgnoreCase(searchTerm));
                break;
            default:
                model.addAttribute("members",memberService.findByNameContainingIgnoreCase(searchTerm));
        }


        return "Member/ListMembers";
    }
}
