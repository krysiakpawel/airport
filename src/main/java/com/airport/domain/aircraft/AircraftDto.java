package com.airport.domain.aircraft;

import com.airport.observer.AircraftsToTurnaround;
import com.airport.observer.Observer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AircraftDto extends AircraftsToTurnaround {

    @JsonProperty("flight_status")
    private String flightStatus;

    @JsonProperty("flight")
    private Flight flight;

    @JsonProperty("airline")
    private Airline airline;

    @JsonProperty("arrival")
    private Arrival arrival;

}
