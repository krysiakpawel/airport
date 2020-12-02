package com.airport.controller;

import com.airport.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/passenger")
public class PassengerController {

    @Autowired
    private AircraftService aircraftService;

    @PutMapping(value = "openBoarding")
    public void openBoarding(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setPassengerStatus(2, flightNumber));
    }

    @PutMapping(value = "closeBoarding")
    public void closeBoarding(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setPassengerStatus(3, flightNumber));
    }

    @PutMapping(value = "requestForDelay")
    public void requestForDelay(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setFlightStatus("delayed", flightNumber));
    }

    @GetMapping(value = "getAircraftStatus")
    public String getAircraftStatus(@RequestParam String flightNumber) {
        return aircraftService.getAircraftStatus(flightNumber);
    }
}
