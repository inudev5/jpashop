package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MemberRepository {

    @PersistenceContext//jpa 표준 어노테이션, 스프링이 빈 등록
    private EntityManager em;

    public void save(Member member){
        em.persist(member);
    }
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findAllByName(String name){
        return em.createQuery("select m from Member m where m.username=:name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}