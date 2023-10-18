package com.fyr.memberproject.dto;

import com.fyr.memberproject.entities.Member;

import java.io.Serializable;


public class MemberDTO  implements Serializable {
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private String email;
    private String phone;

    public MemberDTO() {
    }

    public MemberDTO(String firstName, String lastName, AddressDTO address, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    public MemberDTO(Member member){
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.address = new AddressDTO(member.getAddress());
        this.email = member.getEmail();
        this.phone = member.getPhone();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
