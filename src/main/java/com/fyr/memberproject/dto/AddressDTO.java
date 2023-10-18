package com.fyr.memberproject.dto;

import com.fyr.memberproject.entities.Address;

public class AddressDTO {

    private String street;
    private int zipCode;
    private String city;

    public AddressDTO(){

    }

    public AddressDTO(String street, int zipCode, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }
    public AddressDTO(Address address){
        this.street = address.getStreetName();
        this.zipCode = address.getZipCode();
        this.city = address.getCity();
    }

    public String getStreet() {
        return street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
