package com.fyr.memberproject.repository;

import com.fyr.memberproject.dto.MemberDTO;
import com.fyr.memberproject.entities.Member;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberServiceRepository {

    List<MemberDTO> findAll();
    Member save(Member member);
    Member findById(int id);
}