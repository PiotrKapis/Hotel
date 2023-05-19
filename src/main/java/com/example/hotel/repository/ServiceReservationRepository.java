package com.example.hotel.repository;

import com.example.hotel.model.ServiceReservation;
import org.apache.tomcat.jni.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceReservationRepository extends JpaRepository<ServiceReservation, Long> {
}