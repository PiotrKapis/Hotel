package com.example.hotel.mapper;

import com.example.hotel.dto.GuestDto;
import com.example.hotel.model.Guest;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper {

    public GuestDto toDto(Guest guest) {
        return new GuestDto(
                guest.getGuestId(),
                guest.getFirstname(),
                guest.getLastName(),
                guest.getPhone(),
                guest.getEmail()
        );
    }
}
