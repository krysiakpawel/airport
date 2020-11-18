package com.airport.mapper;


import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.AircraftDto;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapper {

    public Aircraft mapToAircraft(AircraftDto aircraftDto){
        return new Aircraft(
                aircraftDto.getFlightNumber(),
                aircraftDto.getETA(),
                aircraftDto.getETD(),
                aircraftDto.getGate(),
                aircraftDto.getPassengerStatus(),
                aircraftDto.getCargoStatus(),
                aircraftDto.getCleaningStatus(),
                aircraftDto.getMaintenanceStatus(),
                aircraftDto.getFuelingStatus(),
                aircraftDto.getCateringStatus());

    }
}
