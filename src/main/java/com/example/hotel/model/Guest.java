package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue
    private long guestId;

    @Column
    @NotBlank
    private String firstname;
    @Column
    @NotBlank
    private String lastName;
    @Column
    @Pattern(regexp= "^\\+((?:9[679]|8[035789]|6[789]|5[90]|42|3[578]|2[1-689])|9[0-58]|8[1246]|6[0-6]|5[1-8]|4[013-9]|3[0-469]|2[70]|7|1)(?:\\W*\\d){0,13}\\d$")
    private String phone;
    @Column
    @Email
    private String email;

    @OneToMany
    private List<Reservation> reservation;

    public Guest(String firstname, String lastName, String phone, String email) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Guest(long guestId, String firstname, String lastName, String phone, String email) {
        this.guestId = guestId;
        this.firstname = firstname;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Guest() {
    }

    public long getGuestId() {
        return guestId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
