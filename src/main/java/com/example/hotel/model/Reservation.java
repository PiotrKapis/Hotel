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
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
    @ManyToOne(fetch = FetchType.LAZY)
    private Guest guest;
    @ManyToOne(fetch = FetchType.LAZY)
    private BookingStatus bookingStatus;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservation")
    private List<ServiceReservation> serviceReservation;

    public Reservation(long reservationId, LocalDateTime reservationDate, LocalDate dateFrom, LocalDate dateTo, BigDecimal priceReservationPerNight, boolean isPaid, Room room, Guest guest, BookingStatus bookingStatus, List<ServiceReservation> serviceReservation) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.priceReservationPerNight = priceReservationPerNight;
        this.isPaid = isPaid;
        this.room = room;
        this.guest = guest;
        this.bookingStatus = bookingStatus;
        this.serviceReservation = serviceReservation;
    }

    public Reservation(LocalDateTime reservationDate, LocalDate dateFrom, LocalDate dateTo, boolean isPaid, Room room, Guest guest, BookingStatus bookingStatus) {
        this.reservationDate = reservationDate;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isPaid = isPaid;
        this.room = room;
        this.guest = guest;
        this.priceReservationPerNight = room.getPrice();
        this.bookingStatus = bookingStatus;
    }

    public Reservation() {
    }

    public long getReservationId() {
        return reservationId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public BigDecimal getPriceReservationPerNight() {
        return priceReservationPerNight;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public List<ServiceReservation> getServiceReservation() {
        return serviceReservation;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setPriceReservationPerNight(BigDecimal priceReservationPerNight) {
        this.priceReservationPerNight = priceReservationPerNight;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setServiceReservation(List<ServiceReservation> serviceReservation) {
        this.serviceReservation = serviceReservation;
    }
}
