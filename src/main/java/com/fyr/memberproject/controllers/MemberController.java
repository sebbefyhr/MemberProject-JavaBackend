package com.fyr.memberproject.controllers;


import com.fyr.memberproject.dto.MemberDTO;
import com.fyr.memberproject.entities.Member;
import com.fyr.memberproject.exceptions.MemberNotFoundException;
import com.fyr.memberproject.repository.MemberServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mypages")
public class MemberController {

    private MemberServiceRepository memberService;

    @Autowired
    public MemberController(MemberServiceRepository memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members")
    public List<MemberDTO> findAll() {
        List<MemberDTO> memberDTOList = memberService.findAll();
        if(memberDTOList == null || memberDTOList.size() == 0){
            throw new MemberNotFoundException("No members exists in DB");
        }
        return memberDTOList;
    }

    @PutMapping("/members/{id}")
    public Member updateMember(@RequestBody Member member, @ PathVariable int id){
        member.setId(id);
            return memberService.save(member);
    }

}
