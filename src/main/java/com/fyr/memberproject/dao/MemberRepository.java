package com.fyr.memberproject.dao;

import com.fyr.memberproject.entities.Member;
import com.fyr.memberproject.exceptions.MemberNotFoundException;
import com.fyr.memberproject.repository.MemberDAORepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MemberRepository implements MemberDAORepository {

    private EntityManager entityManager;

    @Autowired
    public void MemberRepository (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Member> findAll() {
        TypedQuery<Member> query = entityManager.createQuery("FROM Member",Member.class);
        if(query.getResultList().isEmpty()){
            throw new MemberNotFoundException("Det finns inga medlemmar i databasen.");
        }
        return query.getResultList();
    }

    @Override
    public Member findMemberById(int id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    public Member save(Member member) {
        return entityManager.merge(member);
    }

    @Override
    public void delete(int id) {
        Member member = entityManager.find(Member.class, id);
        entityManager.remove(member);
    }

}
