package com.airport.controller;

import com.airport.client.aviationstack.AviationStackClient;
import com.airport.domain.aircraft.AircraftDto;
import com.airport.mapper.AircraftMapper;
import com.airport.service.AircraftService;
import com.airport.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/ground")
public class GroundController {

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private AircraftMapper aircraftMapper;

    @Autowired
    private AviationStackClient aviationStackClient;

    @GetMapping(value = "getLandedPlanes")
    public void getLandedPlanes() {
        AircraftDto[] aircraftDtos = aviationStackClient.getData();
        for (AircraftDto aircraftDto : aircraftDtos) {
            aircraftService.saveAircraft(aircraftMapper.mapToAircraft(aircraftDto));
        }
    }

    @PutMapping(value = "requestForCleaning")
    public void requestForCleaning(@RequestParam String flightNumber) {
        aircraftService.saveAircraft(aircraftService.setCleaningStatus(1, flightNumber));
    }

    @PutMapping(value = "requestForMaintenance")
    public void requestForMaintenance(@RequestParam String flightNumber) {
        aircraftService.saveAircraft(aircraftService.setMaintenanceStatus(1, flightNumber));
    }

    @PutMapping(value = "requestForBoarding")
    public void requestForBoarding(@RequestParam String flightNumber) {
        aircraftService.saveAircraft(aircraftService.setPassengerStatus(1, flightNumber));
    }

    @PutMapping(value = "requestForCatering")
    public void requestForCatering(@RequestParam String flightNumber) {
        aircraftService.saveAircraft(aircraftService.setCateringStatus(1, flightNumber));
    }

    @PutMapping(value = "requestForFueling")
    public void requestForFueling(@RequestParam String flightNumber) {
        aircraftService.saveAircraft(aircraftService.setFuelingStatus(1, flightNumber));
    }

    @PutMapping(value = "loadCargo")
    public void loadCargo(@RequestParam String flightNumber) {
        aircraftService.saveAircraft(aircraftService.setCargoStatus(3, flightNumber));
    }

    @PutMapping(value = "requestForPushBack")
    public void requestForPushBack(@RequestParam String flightNumber) {
        weatherService.getLatestWeather();
        aircraftService.saveAircraft(aircraftService.checkStatus(flightNumber));
    }

    @DeleteMapping(value = "planeOnTaxiway")
    public void planeOnTaxiway(@RequestParam String flightNumber) {
        aircraftService.planeOnTaxiway(flightNumber);
    }

    @GetMapping(value = "getAircraftStatus")
    public String getAircraftStatus(@RequestParam String flightNumber) {
        return aircraftService.getAircraftStatus(flightNumber);
    }
}
