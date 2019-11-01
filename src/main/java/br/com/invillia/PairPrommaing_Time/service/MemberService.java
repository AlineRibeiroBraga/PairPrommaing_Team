package br.com.invillia.PairPrommaing_Time.service;

import br.com.invillia.PairPrommaing_Time.domain.Member;
import br.com.invillia.PairPrommaing_Time.domain.Team;
import br.com.invillia.PairPrommaing_Time.repository.MemberRepository;
import br.com.invillia.PairPrommaing_Time.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    //@Transactional
    public void save(Member member){
        memberRepository.save(member);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(Long id){
        return memberRepository.findById(id).isEmpty() ? null : memberRepository.findById(id).get();
    }

    @Transactional
    public void delete(Member member){
        memberRepository.delete(member);
    }

    @Transactional
    public void update(Member member){
        Team team = teamRepository.findById(member.getTeam().getId()).get();
        Member member1 = memberRepository.findById(member.getId()).get();
        member.setCreatedAt(member1.getCreatedAt());
        member.setTeam(team);
        memberRepository.save(member);
    }

    public List<Member> findByNameContainingIgnoreCase(String searchTerm) {
        return memberRepository.findByNameContainingIgnoreCase(searchTerm);
    }

    public List<Member> findByTeamNameContainingIgnoreCase(String searchTerm) {
        return memberRepository.findByTeamNameContainingIgnoreCase(searchTerm);
    }

    public List<Member> findAllById(Long id) {
        return memberRepository.findAllById(id);
    }
}
