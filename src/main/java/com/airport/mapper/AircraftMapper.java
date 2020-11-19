package com.airport.mapper;


import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.AircraftDto;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapper {

    public Aircraft mapToAircraft(AircraftDto aircraftDto){
        return new Aircraft(
                aircraftDto.getFlightNumber(),
                aircraftDto.getGate());
    }
     public AircraftDto mapToAircraftDto(final Aircraft aircraft){
        return new AircraftDto(
                aircraft.getFlightNumber(),
                aircraft.getGate());

     }
}
