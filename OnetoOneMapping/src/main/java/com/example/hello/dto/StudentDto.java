package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentDto {
    private String name;
    private String fname;
    private Long id;

    private AddressDto addressDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public StudentDto(String name, String fname, Long id, AddressDto addressDto) {
        this.name = name;
        this.fname = fname;
        this.id = id;
        this.addressDto = addressDto;
    }

    public StudentDto() {
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", id=" + id +
                ", addressDto=" + addressDto +
                '}';
    }
}
