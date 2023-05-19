package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class ServiceReservation {

    @Id
    @GeneratedValue
    private long serviceReservationId;
    @Column
    @NotNull
    private LocalDateTime dateOrder;
    @Column
    private boolean isPaid;
    @Column
    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal price;

    @ManyToOne
    private AdditionalService service;
    @ManyToOne
    private Reservation reservation;

    public ServiceReservation(LocalDateTime dateOrder, boolean isPaid, AdditionalService service, Reservation reservation) {
        this.dateOrder = dateOrder;
        this.isPaid = isPaid;
        this.service = service;
        this.reservation = reservation;
        this.price = service.getPrice();
    }

    public ServiceReservation() {
    }

    public long getServiceReservationId() {
        return serviceReservationId;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AdditionalService getService() {
        return service;
    }

    public Reservation getReservation() {
        return reservation;
    }
}
