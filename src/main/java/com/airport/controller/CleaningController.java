package com.airport.controller;

import com.airport.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cleaning")
public class CleaningController {

    @Autowired
    private AircraftService aircraftService;

    @PutMapping(value = "startAircraftCleaning")
    public void startAircraftCleaning(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setCleaningStatus(2, flightNumber));
    }

    @PutMapping(value = "finishAircraftCleaning")
    public void finishAircraftCleaning(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setCleaningStatus(3, flightNumber));
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
