package com.example.hotel.service;

import com.example.hotel.dto.CancelReservationDto;
import com.example.hotel.model.BookingStatus;
import com.example.hotel.model.Reservation;
import com.example.hotel.model.ServiceReservation;
import com.example.hotel.repository.BookingStatusRepository;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    BookingStatusRepository bookingStatusRepository;

    JavaMailSender javaMailSender;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, BookingStatusRepository bookingStatusRepository, JavaMailSender javaMailSender) {
        this.reservationRepository = reservationRepository;
        this.bookingStatusRepository = bookingStatusRepository;
        this.javaMailSender = javaMailSender;
    }

    public BigDecimal calculateTotalReservationCost(Long id) {
        final Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isEmpty()) {
            throw new IllegalArgumentException("Reservation with id = " + id + " not found");
        }

        final Reservation reservation = reservationOptional.get();
        long daysBetween = DAYS.between(reservation.getDateFrom(), reservation.getDateTo());

        BigDecimal total = reservation.getPriceReservationPerNight().multiply(BigDecimal.valueOf(daysBetween));
        for (ServiceReservation serviceReservation : reservation.getServiceReservation()) {
            total = total.add(serviceReservation.getPrice());
        }
        return total;
    }

    public void cancelReservation(CancelReservationDto cancelReservationDto) {
        final Optional<Reservation> reservationOptional = reservationRepository.findById(cancelReservationDto.getReservationId());
        if (reservationOptional.isEmpty()) {
            throw new IllegalArgumentException("Reservation with id = " + cancelReservationDto.getReservationId()+ " not found");
        }

        final Reservation reservation = reservationOptional.get();
        if (!reservation.getBookingStatus().getStatus().equals("new")) {
            throw new IllegalArgumentException("Can not cancel reservation with status other than 'new'");
        }

        final BookingStatus canceledStatus = bookingStatusRepository.findById(3L).get();
        reservation.setBookingStatus(canceledStatus);
        reservationRepository.save(reservation);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(reservation.getGuest().getEmail());
        simpleMailMessage.setSubject("Your reservation has been canceled");
        simpleMailMessage.setText("Reservation with id = " + cancelReservationDto.getReservationId() + " is canceled. Reason: " + cancelReservationDto.getReason());
        javaMailSender.send(simpleMailMessage);
    }
}
