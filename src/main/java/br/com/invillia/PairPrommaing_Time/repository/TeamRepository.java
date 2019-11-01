package br.com.invillia.PairPrommaing_Time.repository;

import br.com.invillia.PairPrommaing_Time.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    List<Team> findAllById(long id);

    List<Team> findByNameContainingIgnoreCase(String searchTerm);
}
