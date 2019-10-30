package br.com.invillia.PairPrommaing_Time.controller;

import br.com.invillia.PairPrommaing_Time.domain.Team;
import br.com.invillia.PairPrommaing_Time.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("teams",teamService.findAll());

        return "Team/ListTeams";
    }

    @GetMapping("/registerTeam")
    public String register(Team team){
        return "Team/RegisterTeam";
    }

    @PostMapping("/saveTeam")
    public String save(@Valid Team team, BindingResult result, Model model){
        if(result.hasErrors()){
            return "Team/RegisterTeam";
        }

        teamService.save(team);
        model.addAttribute("teams",teamService.findAll());

        return "Team/ListTeams";
    }

    @GetMapping("/editTeam/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Team team = teamService.findById(id);
        model.addAttribute("team",team);

        return  "Team/UpdateTeam";
    }

    @PostMapping("/updateTeam/{id}")
    public String upDate(@PathVariable("id") long id, @Valid Team team, BindingResult result, Model model){

        if(result.hasErrors()){
            team.setId(id);
            return "Team/UpdateTeam";
        }

       teamService.update(team);
        model.addAttribute("teams",teamService.findAll());
        return "Team/ListTeams";
    }

    @GetMapping("/deleteTeam/{id}")
    public String delete(@PathVariable("id") long id, Model model){

        teamService.delete(id);

        model.addAttribute("teams",teamService.findAll());
        return "Team/ListTeams";

    }
}
