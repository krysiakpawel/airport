package com.airport.controller;

import com.airport.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/maintenance")
public class MaintenanceController {

    @Autowired
    private AircraftService aircraftService;

    @PutMapping(value = "maintenanceInProgress")
    public void maintenanceInProgress(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setMaintenanceStatus(2, flightNumber));
    }

    @PutMapping(value = "requestForDelay")
    public void requestForDelay(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setFlightStatus("delayed", flightNumber));
    }

    @PutMapping(value = "cancelPlane")
    public void cancelPlane(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setFlightStatus("cancel", flightNumber));
    }

    @PutMapping(value = "closeMaintenance")
    public void closeMaintenance(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setMaintenanceStatus(3, flightNumber));
    }

    @GetMapping(value = "getAircraftStatus")
    public String getAircraftStatus(@RequestParam String flightNumber) {
        return aircraftService.getAircraftStatus(flightNumber);
    }
}