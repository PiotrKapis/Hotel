package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class BookingStatus {

    @Id
    @GeneratedValue
    private Long booking_status_id;

    @Column
    @NotBlank
    private String status;

    @OneToMany
    private List<Reservation> reservation;

    public BookingStatus(String status) {
        this.status = status;
    }

    public BookingStatus() {
    }

    public String getStatus() {
        return status;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }
}
