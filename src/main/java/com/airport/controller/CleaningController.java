package com.airport.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cleaning")
public class CleaningController {


    @PutMapping(value = "startAircraftCleaning")
    public int startAircraftCleaning(){
        return 1;
    }

    @PutMapping(value = "aircraftCleaningFinished")
    public int aircraftCleaningFinished(){
        return 2;
    }

    @PutMapping(value = "requestForMaintenance")
    public boolean requestForMaintenance(){
        return true;
    }

    @GetMapping(value = "getAircraftStatus")
    public int getAircraftStatus(){
        return 1;
    }
}
