package com.payments.user.domain.valueobjects;

public class Address {
    private String street;
    private String district;
    private String number;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String district, String number, String city, String state, String zip) {
        this.street = street;
        this.district = district;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
