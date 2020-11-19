package com.airport.domain.aircraft;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity(name = "AIRCRAFT")
@NoArgsConstructor
public class Aircraft {

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

    public Aircraft(String flightNumber, int gate){
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

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Column(name = "FLIGHT_NUMBER")
    public String getFlightNumber(){
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }

    @Column(name = "ETA")
    public LocalTime getETA(){
        return ETA;
    }
    public void setETA(LocalTime ETA){
        this.ETA = ETA;
    }

    @Column(name = "ETD")
    public LocalTime getETD(){
        return ETD;
    }
    public void setETD(LocalTime ETD){
        this.ETD = ETD;
    }

    @Column(name = "GATE")
    public int getGate(){
        return gate;
    }
    public void setGate(int gate){
        this.gate = gate;
    }

    @Column(name = "PASSENGER_STS")
    public int getPassengerStatus(){
        return passengerStatus;
    }

    public void setPassengerStatus(int status){
        this.passengerStatus = status;
    }

    @Column(name = "CARGO_STS")
    public int getCargoStatus(){
        return cargoStatus;
    }

    public void setCargoStatus(int status){
        this.cargoStatus = status;
    }

    @Column(name = "CLEANING_STS")
    public int getCleaningStatus(){
        return cleaningStatus;
    }

    public void setCleaningStatus(int status){
        this.cleaningStatus = status;
    }

    @Column(name = "MAINTENANCE_STS")
    public int getMaintenanceStatus(){
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(int status){
        this.maintenanceStatus = status;
    }

    @Column(name = "FUELING_STS")
    public int getFuelingStatus(){
        return fuelingStatus;
    }

    public void setFuelingStatus(int status){
        this.fuelingStatus = status;
    }

    @Column(name = "CATERING_STS")
    public int getCateringStatus(){
        return cateringStatus;
    }

    public void setCateringStatus(int status){
        this.cateringStatus = status;
    }
}
