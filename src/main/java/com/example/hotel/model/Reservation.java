package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long reservationId;

    @Column
    @NotNull
    private LocalDateTime reservationDate;
    @Column
    @NotNull
    private LocalDate dateFrom;
    @Column
    @NotNull
    private LocalDate dateTo;
    @Column
    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal priceReservationPerNight;
    @Column
    private boolean isPaid;

    @ManyToOne
    private Room room;
    @ManyToOne
    private Guest guest;
    @OneToMany
    private List<ServiceReservation> serviceReservation;

    public Reservation(LocalDateTime reservationDate, LocalDate dateFrom, LocalDate dateTo, BigDecimal priceReservation, boolean isPaid, Room room, Guest guest) {
        this.reservationDate = reservationDate;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.priceReservationPerNight = priceReservation;
        this.isPaid = isPaid;
        this.room = room;
        this.guest = guest;
    }

    public Reservation(LocalDateTime reservationDate, LocalDate dateFrom, LocalDate dateTo, boolean isPaid, Room room, Guest guest) {
        this.reservationDate = reservationDate;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isPaid = isPaid;
        this.room = room;
        this.guest = guest;
        this.priceReservationPerNight = room.getPrice();
    }

    public Reservation() {
    }
}
