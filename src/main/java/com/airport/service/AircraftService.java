package com.airport.service;


import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.dao.AircraftDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {

    @Autowired
    private AircraftDao aircraftDao;


    public Aircraft saveAircraft(final Aircraft aircraft){
        return aircraftDao.save(aircraft);
    }

    public void deleteAircraftByFlightNumber(String flightNumber){
        aircraftDao.deleteByFlightNumber(flightNumber);
    }

    public Aircraft getFlight(String flightNumber){
        Aircraft aircraft = aircraftDao.findAircraftByFlightNumber(flightNumber);
        return aircraft;
    }

    public Aircraft setPassengerStatus(int status, String flightNumber) {
        Aircraft aircraft = getFlight(flightNumber);
        aircraft.setPassengerStatus(status);
        return aircraft;
    }
    public Aircraft setCargoStatus(int status, String flightNumber) {
        Aircraft aircraft = getFlight(flightNumber);
        aircraft.setCargoStatus(status);
        return aircraft;
    }

    public Aircraft setCleaningStatus(int status, String flightNumber){
        Aircraft aircraft = getFlight(flightNumber);
        aircraft.setCleaningStatus(status);
        return aircraft;
    }

    public Aircraft setMaintenanceStatus(int status, String flightNumber){
        Aircraft aircraft = getFlight(flightNumber);
        aircraft.setMaintenanceStatus(status);
        return aircraft;
    }
    public Aircraft setFuelingStatus(int status, String flightNumber) {
        Aircraft aircraft = getFlight(flightNumber);
        aircraft.setFuelingStatus(status);
        return aircraft;
    }
    public Aircraft setCateringStatus(int status, String flightNumber) {
        Aircraft aircraft = getFlight(flightNumber);
        aircraft.setCateringStatus(status);
        return aircraft;
    }

    public Aircraft setFlightStatus(String status, String flightNumber){
        Aircraft aircraft = getFlight(flightNumber);
        aircraft.setFlightStatus(status);
        return aircraft;
    }

    public String getAircraftStatus(String flightNumber){
        Aircraft aircraft = getFlight(flightNumber);
        return aircraft.toString();
    }
}
