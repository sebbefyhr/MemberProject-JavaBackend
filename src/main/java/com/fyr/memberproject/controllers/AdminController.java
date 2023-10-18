package com.fyr.memberproject.controllers;


import com.fyr.memberproject.entities.Member;
import com.fyr.memberproject.exceptions.MemberNotFoundException;
import com.fyr.memberproject.repository.AdminServiceRepository;
import com.fyr.memberproject.repository.MemberServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminServiceRepository adminService;

    @Autowired
    public AdminController(AdminServiceRepository adminService){
        this.adminService = adminService;
    }

    @GetMapping("/members")
    public List<Member> findAll(){
        List<Member> allMembersList = adminService.findAll();

        if(allMembersList.isEmpty()){
            throw new MemberNotFoundException("Det finns inga medlemmar i våran databas.");
        }
        return adminService.findAll();
    }

    @GetMapping("/members/{id}")
    public Member findByMemberId(@PathVariable int id){
        Member member = adminService.findMemberById(id);
        if(member == null || member.getId() <= 0){
            throw new MemberNotFoundException("Medlem med ID: " + id + " finns inte i våran databs.");
        }
        return member;
    }

    @PutMapping("/members/{id}")
    public Member updateMember(@RequestBody Member m, @PathVariable int id){

        Member member = adminService.findMemberById(id);

        if(member == null || member.getId() <= 0){
            throw new MemberNotFoundException("Medlem med ID: " + id + " finns inte i våran databs.");
        }

        m.setId(id);
        return adminService.save(m);
    }

    @PostMapping("/members")
    public Member addMember(@RequestBody Member member){
        member.setId(0);
        return adminService.save(member);
    }

    @DeleteMapping("/members/{id}")
    public String deleteMember(@PathVariable int id){
        Member member = adminService.findMemberById(id);

        if(member == null){
            throw new RuntimeException("Medlem med id: " + id + " finns inte i vårt system");
        }
        adminService.delete(id);
        return "Medlemen med id: "+ id+ " är nu borttagen";
    }
}
