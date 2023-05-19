package com.example.hotel.dto;

public class GuestDto {

    private long id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public GuestDto(long id, String firstname, String lastname, String phone, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public GuestDto() {
    }

    public long getId() {
        return id;
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
