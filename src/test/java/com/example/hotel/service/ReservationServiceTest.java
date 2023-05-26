package com.example.hotel.service;

import com.example.hotel.controller.ReservationController;
import com.example.hotel.model.*;
import com.example.hotel.repository.ReservationRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReservationServiceTest {

    @Test
    void calculateTotalReservationCostShouldIncludePaidServices() {
        //given
        ServiceReservation serviceReservation = new ServiceReservation(
                LocalDateTime.now(),
                true,
                new AdditionalService("Spa", new BigDecimal(70)),
                null
        );
        Reservation reservation = new Reservation(
                1L,
                LocalDateTime.now(),
                LocalDate.now(),
                LocalDate.now().plusDays(2),
                new BigDecimal(300),
                true,
                new Room(2, new BigDecimal(300), 1, 301),
                new Guest("Adam", "Mic", "+34523456567", "a.m@gm.com"),
                new BookingStatus("new"),
                List.of(serviceReservation)
        );
        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        when(reservationRepository.findById(any())).thenReturn(Optional.of(reservation));

        ReservationService reservationService = new ReservationService(reservationRepository, null, null);

        //when
        final BigDecimal result = reservationService.calculateTotalReservationCost(1L);

        //then
        assertEquals(new BigDecimal(670), result);
    }
}