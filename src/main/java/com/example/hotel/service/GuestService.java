package com.example.hotel.service;

import com.example.hotel.dto.AddGuestDto;
import com.example.hotel.dto.GuestDto;
import com.example.hotel.dto.UpdateGuestDto;
import com.example.hotel.mapper.GuestMapper;
import com.example.hotel.model.Guest;
import com.example.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService {
    private GuestRepository guestRepository;
    private GuestMapper guestMapper;

    @Autowired
    public GuestService(GuestRepository guestRepository, GuestMapper guestMapper) {
        this.guestRepository = guestRepository;
        this.guestMapper = guestMapper;
    }

    public Long addGuest(AddGuestDto guestDto) {
        Guest newGuest = new Guest(
                guestDto.getFirstname(),
                guestDto.getLastname(),
                guestDto.getPhone(),
                guestDto.getEmail()
        );
        guestRepository.save(newGuest);
        return newGuest.getGuestId();
    }

    public Optional<GuestDto> getGuest(Long id) {
        final Optional<Guest> guestFromRepository = guestRepository.findById(id);
        if (guestFromRepository.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(guestMapper.toDto(guestFromRepository.get()));
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

    public void putGuest(Long id, UpdateGuestDto updateGuestDto) {
        final Optional<Guest> guestFromRepository = guestRepository.findById(id);
        if (guestFromRepository.isEmpty()) {
            throw new IllegalArgumentException("Guest with id = " + id + " not found");
        }
        final Guest guest = guestFromRepository.get();
        guest.setFirstname(updateGuestDto.getFirstname());
        guest.setLastName(updateGuestDto.getLastname());
        guest.setPhone(updateGuestDto.getPhone());
        guest.setEmail(updateGuestDto.getEmail());

        guestRepository.save(guest);
    }
}