package com.airport.domain.loadingSupervisor;

import com.airport.observer.AircraftsToTurnaround;
import com.airport.observer.Observer;
import lombok.Getter;

@Getter
public class LoadingSupervisorDto implements Observer {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private int planesToTurnaround;

    public LoadingSupervisorDto(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public void update(AircraftsToTurnaround aircraftsToTurnaround) {
        planesToTurnaround ++;
        System.out.println("New aircraft for turnaround. Total aircrafts to turnaround: " + planesToTurnaround );
    }
}
