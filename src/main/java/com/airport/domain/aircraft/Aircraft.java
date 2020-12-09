package com.airport.domain.aircraft;

import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "AIRCRAFT")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"FLIGHT_NUMBER"})})
@NoArgsConstructor
public class Aircraft {

    private Long id;
    private String flightStatus;
    private String flightNumber;
    private String airline;
    private String ETA;
    private String gate;
    private boolean isReady;
    private int passengerStatus;
    private int cargoStatus;
    private int cleaningStatus;
    private int maintenanceStatus;
    private int fuelingStatus;
    private int cateringStatus;
    private LoadingSupervisor loadingSupervisor;

    public Aircraft(String flightStatus, String flightNumber, String airline, String ETA, String gate) {
        this.flightStatus = flightStatus;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.ETA = ETA;
        this.gate = gate;
        this.isReady = false;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FLGHT_STS")
    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    @Column(name = "AIRLINE")
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Column(unique = true, name = "FLIGHT_NUMBER")
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Column(name = "ETA")
    public String getETA() {
        return ETA;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }

    @Column(name = "GATE")
    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    @Column(name = "IS_READY")
    public boolean getIsReady(){
        return isReady;
    }

    public void setIsReady(boolean isReady){
        this.isReady = isReady;
    }

    @Column(name = "PSNGR_STS")
    public int getPassengerStatus() {
        return passengerStatus;
    }

    public void setPassengerStatus(int status) {
        this.passengerStatus = status;
    }

    @Column(name = "CARGO_STS")
    public int getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(int status) {
        this.cargoStatus = status;
    }

    @Column(name = "CLNG_STS")
    public int getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(int status) {
        this.cleaningStatus = status;
    }

    @Column(name = "MNTNC_STS")
    public int getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(int status) {
        this.maintenanceStatus = status;
    }

    @Column(name = "FLNG_STS")
    public int getFuelingStatus() {
        return fuelingStatus;
    }

    public void setFuelingStatus(int status) {
        this.fuelingStatus = status;
    }

    @Column(name = "CTRNG_STS")
    public int getCateringStatus() {
        return cateringStatus;
    }

    public void setCateringStatus(int status) {
        this.cateringStatus = status;
    }

    @ManyToOne
    @JoinColumn(name = "SPRVISOR_ID")
    public LoadingSupervisor getLoadingSupervisor() {
        return loadingSupervisor;
    }

    public void setLoadingSupervisor(LoadingSupervisor loadingSupervisor) {
        this.loadingSupervisor = loadingSupervisor;
    }

    public String toString() {
        return "Flight " + getFlightNumber() + " from " + getAirline() + " status: \n"
                + "Flight status: " + getFlightStatus() + ";\n"
                + "ETA: " + getETA() + ";\n"
                + "Planned gate: " + getGate() + ";\n"
                + "Passenger status: " + getPassengerStatus() + ";\n"
                + "Cargo status: " + getCargoStatus() + ";\n"
                + "Cleaning status: " + getCleaningStatus() + ";\n"
                + "Maintenance status: " + getMaintenanceStatus() + ";\n"
                + "Fueling status: " + getFuelingStatus() + ";\n"
                + "Catering status: " + getCateringStatus() + ";";
    }
}
