package com.airport.controller;

import com.airport.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/catering")
public class CateringController {

    @Autowired
    private AircraftService aircraftService;

    @PutMapping(value = "startLoadingCatering")
    public void startLoadingCatering(@RequestParam String flightNumber) {
        aircraftService.saveAircraft(aircraftService.setCateringStatus(2, flightNumber));
    }

    @PutMapping(value = "aircraftCateringFinished")
    public void aircraftCateringFinished(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setCateringStatus(3, flightNumber));
    }

    @PutMapping(value = "requestMaintenance")
    public void requestMaintenance(@RequestParam String flightNumber){
        aircraftService.saveAircraft(aircraftService.setMaintenanceStatus(1, flightNumber));
    }

    @GetMapping(value = "getAircraftStatus")
    public int getAircraftStatus(){
        return 1;
    }
}
