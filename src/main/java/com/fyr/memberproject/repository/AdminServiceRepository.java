package com.fyr.memberproject.repository;

import com.fyr.memberproject.entities.Member;

import java.util.List;

public interface AdminServiceRepository {
    List<Member> findAll();
    Member findMemberById(int id);
    Member save(Member member);
    void delete(int id);

}
