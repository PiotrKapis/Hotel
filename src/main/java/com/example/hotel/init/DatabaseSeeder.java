package com.example.hotel.init;

import com.example.hotel.model.*;
import com.example.hotel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DatabaseSeeder implements ApplicationRunner {

    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;
    private RoomRepository roomRepository;
    private ServiceRepository serviceRepository;
    private ServiceReservationRepository serviceReservationRepository;

    @Autowired
    public DatabaseSeeder(GuestRepository guestRepository,
                          ReservationRepository reservationRepository,
                          RoomRepository roomRepository,
                          ServiceRepository serviceRepository,
                          ServiceReservationRepository serviceReservationRepository) {
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.serviceRepository = serviceRepository;
        this.serviceReservationRepository = serviceReservationRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AdditionalService freshBathrobe = new AdditionalService("fresh bathrobe", new BigDecimal(30));
        AdditionalService roomServiceBreakfast = new AdditionalService("room service breakfast", new BigDecimal(35));
        AdditionalService wakeup = new AdditionalService("wakeup", new BigDecimal(0));
        AdditionalService snack = new AdditionalService("snack", new BigDecimal(10));
        AdditionalService spaService = new AdditionalService("SPA", new BigDecimal(60));

        serviceRepository.save(freshBathrobe);
        serviceRepository.save(roomServiceBreakfast);
        serviceRepository.save(wakeup);
        serviceRepository.save(snack);
        serviceRepository.save(spaService);

        Guest tomek = new Guest("Tomasz", "Kowal", "+44434566888", "tom@gm.com");
        Guest ala = new Guest("Ala", "Nowak", "+48456769867", "ala@gm.com");
        Guest ola = new Guest("Ola", "Loka", "+58456789098", "ola@gm.com");
        Guest iza = new Guest("Iza", "Kowalska", "+44434566889", "iza@gm.com");

        guestRepository.save(tomek);
        guestRepository.save(ala);
        guestRepository.save(ola);
        guestRepository.save(iza);

        Room room1 = new Room(2, new BigDecimal(200), 1, 101);
        Room room2 = new Room(3, new BigDecimal(280), 1, 102);
        Room room3 = new Room(2, new BigDecimal(400), 3, 401);
        Room room4 = new Room(2, new BigDecimal(300), 2, 201);

        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);
        roomRepository.save(room4);

        Reservation alaReservation = new Reservation(LocalDateTime.now(), LocalDate.now(), LocalDate.now().plusDays(2), true, room1, ala);
        Reservation olaReservation = new Reservation(LocalDateTime.now(), LocalDate.now().plusDays(3), LocalDate.now().plusDays(5), false, room2, ola);
        Reservation izaReservation = new Reservation(LocalDateTime.now(), LocalDate.now().plusDays(6), LocalDate.now().plusDays(10), true, room4, iza);

        reservationRepository.save(alaReservation);
        reservationRepository.save(olaReservation);
        reservationRepository.save(izaReservation);

        ServiceReservation alaService = new ServiceReservation(LocalDateTime.now(), true, freshBathrobe, alaReservation);
        ServiceReservation olaService = new ServiceReservation(LocalDateTime.now(), false, wakeup, olaReservation);
        ServiceReservation izaService = new ServiceReservation(LocalDateTime.now(), true, snack, izaReservation);

        serviceReservationRepository.save(alaService);
        serviceReservationRepository.save(olaService);
        serviceReservationRepository.save(izaService);
    }
}
