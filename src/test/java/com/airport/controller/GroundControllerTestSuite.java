package com.airport.controller;

import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.dao.AircraftDao;
import com.airport.service.AircraftService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroundControllerTestSuite {

    @Autowired
    GroundController groundController;
    @Autowired
    CateringController cateringController;
    @Autowired
    CleaningController cleaningController;
    @Autowired
    FuelingController fuelingController;
    @Autowired
    MaintenanceController maintenanceController;
    @Autowired
    PassengerController passengerController;
    @Autowired
    AircraftDao aircraftDao;
    @Autowired
    AircraftService aircraftService;


    @Test
    public void shouldReturnIsReadyTrue() {

        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cateringController.aircraftCateringFinished("FI123");
        cleaningController.finishAircraftCleaning("FI123");
        fuelingController.fuelingFinished("FI123");
        maintenanceController.closeMaintenance("FI123");
        passengerController.closeBoarding("FI123");
        groundController.loadCargo("FI123");
        groundController.requestForPushBack("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertEquals(3, testAircraft.getCateringStatus());
        Assert.assertEquals(3, testAircraft.getCleaningStatus());
        Assert.assertEquals(3, testAircraft.getFuelingStatus());
        Assert.assertEquals(3, testAircraft.getMaintenanceStatus());
        Assert.assertEquals(3, testAircraft.getPassengerStatus());
        Assert.assertEquals(3, testAircraft.getCargoStatus());
        Assert.assertTrue(testAircraft.getIsReady());

        //CleanUp
        aircraftDao.deleteByFlightNumber(testAircraft.getFlightNumber());

    }

    @Test
    public void shouldReturnIsReadyFalse() {

        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        groundController.requestForPushBack("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertEquals("FI123", testAircraft.getFlightNumber());
        Assert.assertFalse(testAircraft.getIsReady());

        //CleanUp
        aircraftDao.deleteByFlightNumber(testAircraft.getFlightNumber());
    }

    @Test
    public void shouldNotDeleteAircraft() {

        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);

        //When + Then
        Assert.assertTrue(aircraft1.isPresent());
        String status = aircraftService.planeOnTaxiway("FI123");
        Assert.assertEquals("Plane can not be deleted yet, it is still on gate!", status);

        //CleanUp
        aircraftDao.deleteById(id);

    }

    @Test
    public void shouldDeleteAircraft() {

        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cateringController.aircraftCateringFinished("FI123");
        cleaningController.finishAircraftCleaning("FI123");
        fuelingController.fuelingFinished("FI123");
        maintenanceController.closeMaintenance("FI123");
        passengerController.closeBoarding("FI123");
        groundController.loadCargo("FI123");
        groundController.requestForPushBack("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertTrue(aircraft1.isPresent());
        groundController.planeOnTaxiway(testAircraft.getFlightNumber());
        Assert.assertEquals(null, aircraftDao.findAircraftByFlightNumber("FI123"));

    }
}