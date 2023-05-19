package com.example.hotel.dto;

public class UpdateGuestDto {

    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public UpdateGuestDto(String firstname, String lastname, String phone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public UpdateGuestDto() {
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
