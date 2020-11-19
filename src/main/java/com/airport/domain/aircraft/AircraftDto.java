package com.airport.domain.aircraft;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class AircraftDto {

    private Long id;
    private String flightNumber;
    private LocalTime ETA;
    private LocalTime ETD;
    private int gate;
    private int passengerStatus;
    private int cargoStatus;
    private int cleaningStatus;
    private int maintenanceStatus;
    private int fuelingStatus;
    private int cateringStatus;

    public AircraftDto(String flightNumber, int gate){
        this.flightNumber = flightNumber;
        this.ETA = LocalTime.now();
        this.ETD = LocalTime.now();
        this.gate = gate;
        this.passengerStatus = 0;
        this.cargoStatus = 0;
        this.cleaningStatus = 0;
        this.maintenanceStatus = 0;
        this.fuelingStatus = 0;
        this.cateringStatus = 0;
    }
}
