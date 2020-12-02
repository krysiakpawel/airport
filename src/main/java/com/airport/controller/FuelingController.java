package com.airport.controller;

import com.airport.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/fueling")
public class FuelingController {

    @Autowired
    private AircraftService aircraftService;

    @PutMapping(value = "startFueling")
    public void startFueling(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setFuelingStatus(2, flightNumber));
    }

    @PutMapping(value = "fuelingFinished")
    public void fuelingFinished(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setFuelingStatus(3, flightNumber));
    }

    @PutMapping(value = "requestForMaintenance")
    public void requestForMaintenance(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setMaintenanceStatus(1, flightNumber));
    }

    @GetMapping(value = "getAircraftStatus")
    public String getAircraftStatus(@RequestParam String flightNumber) {
        return aircraftService.getAircraftStatus(flightNumber);
    }
}
