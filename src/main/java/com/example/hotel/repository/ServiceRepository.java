package com.example.hotel.repository;

import com.example.hotel.model.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<AdditionalService, Long> {
}
