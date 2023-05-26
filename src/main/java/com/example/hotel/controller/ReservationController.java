package com.example.hotel.controller;


import com.example.hotel.dto.CancelReservationDto;
import com.example.hotel.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Operation(summary = "Get total reservation cost including additional paid services")
    @GetMapping("/{id}")
    public BigDecimal getTotalReservationCost(@PathVariable Long id) {
        return reservationService.calculateTotalReservationCost(id);
    }

    @Operation(summary = "Cancel reservation")
    @PostMapping
    public void cancelReservation(@RequestBody CancelReservationDto cancelReservationDto){
        reservationService.cancelReservation(cancelReservationDto);
    }
}
