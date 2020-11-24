package com.airport.controller;

import com.airport.client.aviationstack.AviationStackClient;
import com.airport.domain.aircraft.AircraftDto;
import com.airport.mapper.AircraftMapper;
import com.airport.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ground")
public class GroundController {

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private AircraftMapper aircraftMapper;

    @Autowired
    private AviationStackClient aviationStackClient;


    @GetMapping(value = "getLandedPlanes")
    public void getLandedPlanes(){
//        System.out.println(aviationStackClient.getLandedAircrafts().getAirline());
//        System.out.println(aviationStackClient.getLandedAircrafts().getArrival().getETA());
//        System.out.println(aviationStackClient.getLandedAircrafts().getFlight().getIata());
//

        List<AircraftDto> aircraftDtoList = aviationStackClient.getLandedAircrafts();
        for(AircraftDto aircraftDto : aircraftDtoList){
            aircraftService.saveAircraft(aircraftMapper.mapToAircraft(aircraftDto));
        }
    }

    @PostMapping(value ="planeOnGate" )
    public void planeOnGate(@RequestBody AircraftDto aircraftDto){
        aircraftService.saveAircraft(aircraftMapper.mapToAircraft(aircraftDto));
    }

    @PutMapping(value = "requestForCleaning")
    public String requestForCleaning(){
        return "Requesting for Cleaning";
    }

    @PutMapping(value = "requestForMaintenance")
    public String requestForMaintenance(){
        return "Requesting for Maintenance";
    }

    @PutMapping(value = "requestForBoarding")
    public String requestForBoarding(){
        return "Requesting for Boarding";
    }

    @PutMapping(value = "requestForCatering")
    public String requestForCatering(){
        return "Requesting for Catering";
    }

    @PutMapping(value = "requestForFueling")
    public String requestForFueling(){
        return "Requesting for Fueling";
    }

    @PutMapping(value = "loadCargo")
    public boolean loadCargo(){
        return true;
    }

    @PutMapping(value = "requestForPushBack")
    public String requestForPushBack(){
        return "Requesting for push back";
    }

    @DeleteMapping(value = "planeOnTaxiway")
    public void planeOnTaxiway(@RequestParam Long id){
        aircraftService.deleteAircraftById(id);
    }

    @GetMapping(value = "getAircraftStatus")
    public void getAircraftStatus(){

    }
}
