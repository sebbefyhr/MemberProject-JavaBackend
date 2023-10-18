package com.fyr.memberproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="street")
    private String streetName;

    @Column(name="zipcode")
    private int zipCode;

    @Column(name="city")
    private String city;

    public Address(){

    }

    public Address(String streetName, int zipCode, String city) {
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + zipCode +
                ", city='" + city + '\'' +
                '}';
    }
}
