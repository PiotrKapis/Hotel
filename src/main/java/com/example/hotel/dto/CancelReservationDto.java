package com.example.hotel.dto;

public class CancelReservationDto {

    private Long reservationId;
    private String reason;

    public CancelReservationDto() {
    }

    public CancelReservationDto(Long reservationId, String reason) {
        this.reservationId = reservationId;
        this.reason = reason;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public String getReason() {
        return reason;
    }
}
