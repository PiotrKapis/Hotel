package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private long roomId;

    @Column
    @Min(value = 0)
    private int numberOfBeds;
    @Column
    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal price;
    @Column
    @Min(value = 1)
    @Max(value = 5)
    private int standard;
    @Column
    @NotNull
    @Min(value = 0)
    private int roomNumber;

    @OneToMany
    private List<Reservation> reservation;

    public Room(int numberOfBeds, BigDecimal price, int standard, int roomNumber) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.standard = standard;
        this.roomNumber = roomNumber;
    }

    public Room() {
    }

    public long getRoomId() {
        return roomId;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStandard() {
        return standard;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }
}
