package com.example.hotel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "service")
public class AdditionalService {

    @Id
    @GeneratedValue
    private long serviceId;

    @Column
    @NotBlank
    private String name;
    @Column
    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal price;

    @OneToMany
    private List<ServiceReservation> serviceReservation;

    public AdditionalService(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public AdditionalService() {
    }

    public long getServiceId() {
        return serviceId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<ServiceReservation> getServiceReservation() {
        return serviceReservation;
    }
}
