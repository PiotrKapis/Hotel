package com.example.hotel.mapper;

import com.example.hotel.dto.GuestDto;
import com.example.hotel.model.Guest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestMapperTest {

    @Test
    void toDtoShouldMapAllFields() {
        //given
        Guest guest = new Guest(
                1L,
                "Jaś",
                "Fasola",
                "+56787898909",
                "jan@gm.com"
        );
        GuestMapper guestMapper = new GuestMapper();

        //When
        final GuestDto result = guestMapper.toDto(guest);

        //Then
        assertEquals(guest.getGuestId(), result.getId());
        assertEquals(guest.getFirstname(), result.getFirstname());
        assertEquals(guest.getLastName(), result.getLastname());
        assertEquals(guest.getPhone(), result.getPhone());
        assertEquals(guest.getEmail(), result.getEmail());
    }
}