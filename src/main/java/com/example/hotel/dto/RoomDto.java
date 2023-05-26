package com.example.hotel.dto;

import java.math.BigDecimal;

public class RoomDto {

    private Long id;
    private int numberOfBeds;
    private BigDecimal price;
    private int standard;
    private int roomNumber;

    public RoomDto(Long id, int numberOfBeds, BigDecimal price, int standard, int roomNumber) {
        this.id = id;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.standard = standard;
        this.roomNumber = roomNumber;
    }

    public RoomDto() {
    }

    public Long getId() {
        return id;
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
}
