package br.com.invillia.PairPrommaing_Time.service;

import br.com.invillia.PairPrommaing_Time.domain.Team;
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
        return teamRepository.findById(id).isEmpty() ? null : teamRepository.findById(id).get();
    }

    @Transactional
    public void save(Team team) {
        teamRepository.save(team);
    }

    @Transactional
    public void delete(Long id){
        teamRepository.deleteById(id);
    }

    @Transactional
    public void update(Team team){
        teamRepository.save(team);
    }
}