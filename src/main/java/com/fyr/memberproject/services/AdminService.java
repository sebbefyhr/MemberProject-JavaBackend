package com.fyr.memberproject.services;

import com.fyr.memberproject.entities.Member;
import com.fyr.memberproject.exceptions.MemberNotFoundException;
import com.fyr.memberproject.repository.AdminServiceRepository;
import com.fyr.memberproject.repository.MemberDAORepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminServiceRepository {

    private MemberDAORepository memberDAO;

    @Autowired
    public AdminService(MemberDAORepository memberDAORepository) {
        this.memberDAO = memberDAORepository;
    }

    @Override
    public List<Member> findAll() {
        return memberDAO.findAll();
    }

    @Override
    public Member findMemberById(int id) {

        return memberDAO.findMemberById(id);
    }

    @Override
    @Transactional
    public Member save(Member member) {
        return memberDAO.save(member);
    }

    @Override
    @Transactional
    public void delete(int id) {
        memberDAO.delete(id);
    }

}
