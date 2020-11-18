package com.airport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/catering")
public class CateringController {

    @PutMapping(value = "startLoadingCatering")
    public int startLoadingCatering() {
        return 1;
    }

    @PutMapping(value = "aircraftCateringFinished")
    public int aircraftCateringFinished(){
        return 2;
    }

    @PutMapping(value = "requestMaintenance")
    public boolean requestMaintenance(){
        return true;
    }

    @GetMapping(value = "getAircraftStatus")
    public int getAircraftStatus(){
        return 1;
    }
}
