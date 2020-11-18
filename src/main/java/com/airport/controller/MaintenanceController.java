package com.airport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/maintenance")
public class MaintenanceController {


    @PutMapping(value = "maintenanceInProgress")
    public boolean maintenanceInProgress(){
        return true;
    }

    @PutMapping(value = "requestForDelay")
    public int requestForDelay(){
        return 1;
    }

    @PutMapping(value = "cancelPlane")
    public int cancelPlane(){
        return 2;
    }

    @PutMapping(value = "closeMaintenance")
    public int closeMaintenance(){
        return 0;
    }

    @GetMapping(value = "getAircraftStatus")
    public int getAircraftStatus(){
        return 1;
    }
}