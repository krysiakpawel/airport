package com.airport.observer;

import com.airport.domain.aircraft.*;
import com.airport.domain.loadingSupervisor.LoadingSupervisorDto;
import org.junit.Assert;
import org.junit.Test;

public class ObserverTestSuite {

    @Test
    public void testUpdate(){

        //Given
        AircraftsToTurnaround aircraftsToTurnaround = new AircraftsToTurnaround();
        LoadingSupervisorDto janNowak = new LoadingSupervisorDto("Jan", "Nowak", "test@test");
        AircraftDto aircraft1 = new AircraftDto(
                "landed",
                new Flight("KEF"),
                new Airline("TESTAIR"),
                new Arrival("2020-12-01T15:25:00+00:00", "A1" ));
        //When
        aircraftsToTurnaround.registerObserver(janNowak);
        aircraftsToTurnaround.getAircraftsToTurnaround().add(aircraft1);
        //Then
        Assert.assertEquals(1,janNowak.getPlanesToTurnaround());

    }
}
