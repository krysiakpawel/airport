package com.airport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/fueling")
public class FuelingController {


    @PutMapping(value = "startFueling")
    public int startFueling(){
        return 1;
    }

    @PutMapping(value = "fuelingFinished")
    public int fuelingFinished(){
        return 1;
    }

    @PutMapping(value = "requestForMaintenance")
    public int requestForMaintenance(){
        return 1;
    }

    @GetMapping(value = "getAircraftStatus")
    public int getAircraftStatus(){
        return 1;
    }




}
