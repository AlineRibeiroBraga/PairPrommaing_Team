package br.com.invillia.PairPrommaing_Time.repository;

import br.com.invillia.PairPrommaing_Time.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
}
