package com.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Address {


    @Column(name = "city_name")  //column creating using @Annotation
    private String city;

    @Column(name = "state_name")
    private String state;

    private String pincode;

    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
