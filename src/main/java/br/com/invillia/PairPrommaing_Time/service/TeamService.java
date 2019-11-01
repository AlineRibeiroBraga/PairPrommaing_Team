package br.com.invillia.PairPrommaing_Time.service;

import br.com.invillia.PairPrommaing_Time.domain.Team;
import br.com.invillia.PairPrommaing_Time.exception.ActionNotPermitedException;
import br.com.invillia.PairPrommaing_Time.exception.TeamNotFoundException;
import br.com.invillia.PairPrommaing_Time.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findById(Long id) {

        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(String.valueOf(id)));

        return team;
    }

    @Transactional
    public void save(Team team) {
        teamRepository.save(team);
    }

    @Transactional
    public void delete(Long id){
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(String.valueOf(id)));
        teamRepository.delete(team);
    }

    @Transactional

    public void update(Team team){

        Team team1 = teamRepository.findById(team.getId()).get();
        team.setCreatedAt(team1.getCreatedAt());
        teamRepository.save(team);
    }

    public List<Team> findAllById(Long id) {

        return teamRepository.findAllById(id);
    }

    public List<Team> findByNameContainingIgnoreCase(String searchTerm) {
        return teamRepository.findByNameContainingIgnoreCase(searchTerm);
    }
}