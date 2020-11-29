package com.airport.mapper;

import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.AircraftDto;
import org.springframework.stereotype.Component;


@Component
public class AircraftMapper {

    public Aircraft mapToAircraft(AircraftDto aircraftDto){
        return new Aircraft(
                aircraftDto.getFlightStatus(),
                aircraftDto.getFlight().getIata(),
                aircraftDto.getAirline().getAirline(),
                aircraftDto.getArrival().getETA(),
                aircraftDto.getArrival().getGate()
                );
    }
}
