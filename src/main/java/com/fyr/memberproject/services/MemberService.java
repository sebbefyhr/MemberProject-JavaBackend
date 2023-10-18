package com.fyr.memberproject.services;

import com.fyr.memberproject.dto.AddressDTO;
import com.fyr.memberproject.dto.MemberDTO;
import com.fyr.memberproject.entities.Address;
import com.fyr.memberproject.entities.Member;
import com.fyr.memberproject.repository.MemberDAORepository;
import com.fyr.memberproject.repository.MemberServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService implements MemberServiceRepository {

    private MemberDAORepository memberDAO;

    @Autowired
    public MemberService (MemberDAORepository memberDAORepository){
        this.memberDAO = memberDAORepository;
    }
    @Override
    public List<MemberDTO> findAll() {

        return memberDAO
                .findAll()
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Member save(Member member) {
        return memberDAO.save(member);
    }

    @Override
    public Member findById(int id) {
        return memberDAO.findMemberById(id);
    }



    private MemberDTO convertDataIntoDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        AddressDTO addressDTO = new AddressDTO();

        Address address = member.getAddress();

        addressDTO.setStreet(address.getStreetName());
        addressDTO.setZipCode(address.getZipCode());
        addressDTO.setCity(address.getCity());

        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setAddress(addressDTO);
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPhone(member.getPhone());

        return memberDTO;
    }
}