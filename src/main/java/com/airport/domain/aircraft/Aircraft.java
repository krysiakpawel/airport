package com.airport.domain.aircraft;


import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Entity(name = "AIRCRAFT")
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightNumber;
    private LocalTime ETA;
    private LocalDateTime ETD;
    private int gate;
    private int passengerStatus;
    private int cargoStatus;
    private int cleaningStatus;
    private int maintenanceStatus;
    private int fuelingStatus;
    private int cateringStatus;

    public Aircraft(String flightNumber, LocalTime ETA, LocalDateTime ETD, int gate,
                    int passengerStatus, int cargoStatus, int cleaningStatus,
                    int maintenanceStatus, int fuelingStatus, int cateringStatus){
        this.flightNumber = flightNumber;
        this.ETA = LocalTime.now();
        this.ETD = LocalDateTime.now();
        this.gate = gate;
        this.passengerStatus = passengerStatus;
        this.cargoStatus = cargoStatus;
        this.cleaningStatus = cleaningStatus;
        this.maintenanceStatus = maintenanceStatus;
        this.fuelingStatus = fuelingStatus;
        this.cateringStatus = cateringStatus;

    }
}
