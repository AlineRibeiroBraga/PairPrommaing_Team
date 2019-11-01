package br.com.invillia.PairPrommaing_Time.repository;

import br.com.invillia.PairPrommaing_Time.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    
    List<Member> findAllById(Long id);

    List<Member> findByTeamNameContainingIgnoreCase(String searchTerm);

    List<Member> findByNameContainingIgnoreCase(String searchTerm);
}
