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
public class CateringControllerTestSuite {

    @Autowired
    AircraftDao aircraftDao;

    @Autowired
    CateringController cateringController;

    @Test
    public void shouldStartLoadingCatering() {

        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cateringController.startLoadingCatering("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertEquals("FI123", testAircraft.getFlightNumber());
        Assert.assertEquals(2, testAircraft.getCateringStatus());

        //Clean-up
        aircraftDao.deleteById(id);
    }

    @Test
    public void shouldFinishLoadingCatering() {
        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cateringController.aircraftCateringFinished("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertEquals("FI123", testAircraft.getFlightNumber());
        Assert.assertEquals(3, testAircraft.getCateringStatus());

        //Clean-up
        aircraftDao.deleteById(id);
    }

    @Test
    public void shouldRequestMaintenance() {
        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cateringController.requestMaintenance("FI123");

        //Then
        Long id = aircraft.getId();
        Optional<Aircraft> aircraft1 = aircraftDao.findById(id);
        Aircraft testAircraft = aircraft1.get();
        Assert.assertEquals("FI123", testAircraft.getFlightNumber());
        Assert.assertEquals(1, testAircraft.getMaintenanceStatus());

        //Clean-up
        aircraftDao.deleteById(id);
    }

    @Test
    public void shouldReturnAircraftStatus() {

        //Given
        Aircraft aircraft = new Aircraft("landed", "FI123", "Icelandair", "2020-12-02T15:25:00+00:00", "A01");
        aircraftDao.save(aircraft);

        //When
        cateringController.aircraftCateringFinished("FI123");
        cateringController.requestMaintenance("FI123");
        String status = cateringController.getAircraftStatus("FI123");

        //Then
        Assert.assertEquals(status, "Flight FI123 from Icelandair status: \n" +
                "Flight status: landed;\n" +
                "ETA: 2020-12-02T15:25:00+00:00;\n" +
                "Planned gate: A01;\n" +
                "Passenger status: 0;\n" +
                "Cargo status: 0;\n" +
                "Cleaning status: 0;\n" +
                "Maintenance status: 1;\n" +
                "Fueling status: 0;\n" +
                "Catering status: 3;");


                //Clean-up
                aircraftDao.deleteByFlightNumber("FI123");

    }
}
