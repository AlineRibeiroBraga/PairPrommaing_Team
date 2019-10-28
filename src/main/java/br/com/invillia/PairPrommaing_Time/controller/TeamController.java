package br.com.invillia.PairPrommaing_Time.controller;

import br.com.invillia.PairPrommaing_Time.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public String findAll(Model model){
        model.addAttribute("teams",teamService.findAll());

        return "ListarTeams";
    }


}
