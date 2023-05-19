package com.example.hotel.controller;

import com.example.hotel.dto.AddGuestDto;
import com.example.hotel.dto.UpdateGuestDto;
import com.example.hotel.repository.GuestRepository;
import com.example.hotel.service.GuestService;
import com.example.hotel.dto.GuestDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private GuestRepository guestRepository;

    private GuestService guestService;

    @Autowired
    public GuestController(GuestRepository guestRepository, GuestService guestService) {
        this.guestRepository = guestRepository;
        this.guestService = guestService;
    }

    @Operation(summary = "Get Guest by Id")
    @GetMapping("/{id}")
    public Optional<GuestDto> getGuest(@PathVariable Long id) {
        return guestService.getGuest(id);
    }

    @Operation(summary = "Add new guest")
    @PostMapping
    public Long addGuest(@RequestBody AddGuestDto addGuestDto) {
        return guestService.addGuest(addGuestDto);
    }

    @Operation(summary = "Delete Guest")
    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
    }

    @Operation(summary = "Overwrite existing guest")
    @PutMapping("/{id}")
    public void putGuest(@PathVariable Long id, @RequestBody UpdateGuestDto updateGuestDto) {
        guestService.putGuest(id, updateGuestDto);
    }
}