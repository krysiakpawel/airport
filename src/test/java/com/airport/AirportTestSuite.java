package com.airport;

import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.dao.AircraftDao;
import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import com.airport.domain.loadingSupervisor.dao.LoadingSupervisorDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirportTestSuite {

    @Autowired
    LoadingSupervisorDao loadingSupervisorDao;
    @Autowired
    AircraftDao aircraftDao;

    @Test
    public void testAircraftSaveWithSupervisor(){

        //Given

        Aircraft aircraft1 = new Aircraft("landed", "FITEST", "TESTAIRLINES", "2020-12-01T13:05:00+00:00", "D16");
        LoadingSupervisor JanKowalski = new LoadingSupervisor("Jan", "Kowalski1", "test@test");
        aircraft1.setLoadingSupervisor(JanKowalski);
        //When
        loadingSupervisorDao.save(JanKowalski);
        aircraftDao.save(aircraft1);

        long id = JanKowalski.getId();
        //Then
        Assert.assertNotEquals(0,id);




    }
}
