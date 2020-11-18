package com.airport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/passenger")
public class PassengerController {

    @PutMapping(value = "openBoarding")
    public boolean openBoarding(){
        return true;
    }

    @PutMapping(value = "closeBoarding")
    public boolean closeBoarding(){
        return true;
    }

    @PutMapping(value = "requestForDelay")
    public int requestForDelay(){
        return 1;
    }

    @GetMapping(value = "getAircraftStatus")
    public void getAircraftStatus(){
    }
}
