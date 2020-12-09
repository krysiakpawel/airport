package com.airport.mapper;

import com.airport.domain.aircraft.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AircraftMapper.class);

    public static Aircraft mapToAircraft(AircraftDto aircraftDto) {
        try {
            return new Aircraft(
                    aircraftDto.getFlightStatus(),
                    aircraftDto.getFlight().getIata(),
                    aircraftDto.getAirline().getAirline(),
                    aircraftDto.getArrival().getETA(),
                    aircraftDto.getArrival().getGate());
        } catch (Exception e) {
            LOGGER.error("Could not map aircraftDto to aircraft. Error: ", e);
            return null;
        }
    }

    public static AircraftDto mapToAircraftDto(Aircraft aircraft) {
        try {
            return new AircraftDto(aircraft.getFlightStatus(),
                    new Flight(aircraft.getFlightNumber()),
                    new Airline(aircraft.getAirline()),
                    new Arrival(aircraft.getETA(), aircraft.getGate()));
        } catch (Exception e) {
            LOGGER.error("Could not map aircraft to aircraftDto. Error: ", e);
            return null;
        }
    }
}
