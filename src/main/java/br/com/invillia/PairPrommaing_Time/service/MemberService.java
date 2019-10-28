package br.com.invillia.PairPrommaing_Time.service;

import br.com.invillia.PairPrommaing_Time.domain.Member;
import br.com.invillia.PairPrommaing_Time.domain.Team;
import br.com.invillia.PairPrommaing_Time.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
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
        memberRepository.save(member);
    }

}
