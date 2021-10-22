package com.example.hello.dto;

public class AddressDto {
    private String streetLine1;

    private String pinCode;
    private String country;

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }



    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressDto(String streetLine1, String streetLine2, String pinCode, String country) {
        this.streetLine1 = streetLine1;
        this.pinCode = pinCode;
        this.country = country;
    }

    public AddressDto() {
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "streetLine1='" + streetLine1 + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
