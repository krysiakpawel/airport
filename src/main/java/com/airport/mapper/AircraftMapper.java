package com.airport.mapper;

import com.airport.domain.aircraft.*;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapper {

    public static Aircraft mapToAircraft(AircraftDto aircraftDto) {
        return new Aircraft(
                aircraftDto.getFlightStatus(),
                aircraftDto.getFlight().getIata(),
                aircraftDto.getAirline().getAirline(),
                aircraftDto.getArrival().getETA(),
                aircraftDto.getArrival().getGate());
    }

    public static AircraftDto mapToAircraftDto(Aircraft aircraft) {
        return new AircraftDto(aircraft.getFlightStatus(),
                new Flight(aircraft.getFlightNumber()),
                new Airline(aircraft.getAirline()),
                new Arrival(aircraft.getETA(), aircraft.getGate()));

    }
}
