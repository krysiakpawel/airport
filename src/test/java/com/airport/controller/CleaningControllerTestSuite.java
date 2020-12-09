package com.airport.controller;

import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.dao.AircraftDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CleaningControllerTestSuite {

    @Autowired
    AircraftDao aircraftDao;

    @Autowired
    CleaningController cleaningController;

    @Test
    public void shouldStartAircraftCleaning() {

        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cleaningController.startAircraftCleaning("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertEquals("FI123", testAircraft.getFlightNumber());
        Assert.assertEquals(2, testAircraft.getCleaningStatus());

        //CleanUp
        aircraftDao.deleteByFlightNumber(testAircraft.getFlightNumber());
    }


    @Test
    public void shouldFinishAircraftCleaning() {

        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cleaningController.finishAircraftCleaning("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertEquals("FI123", testAircraft.getFlightNumber());
        Assert.assertEquals(3, testAircraft.getCleaningStatus());

        //CleanUp
        aircraftDao.deleteByFlightNumber(testAircraft.getFlightNumber());
    }

    @Test
    public void shouldRequestForMaintenance() {
        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cleaningController.requestForMaintenance("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertEquals("FI123", testAircraft.getFlightNumber());
        Assert.assertEquals(1, testAircraft.getMaintenanceStatus());

        //Clean-up
        aircraftDao.deleteById(id);

    }
}


