package com.airport.observer;

import com.airport.domain.aircraft.AircraftDto;

import java.util.ArrayList;
import java.util.List;

public class AircraftsToTurnaround implements Observable{

    private final List<Observer> loadingSupervisors;
    private final List<Observable> aircraftsToTurnaround;


    public AircraftsToTurnaround(){
        loadingSupervisors = new ArrayList<>();
        aircraftsToTurnaround = new ArrayList<>();
    }

    public List<Observer> getObservers(){
        return loadingSupervisors;
    }

    public List<Observable> getAircraftsToTurnaround(){
        return aircraftsToTurnaround;
    }

    public void addAircraft(AircraftDto aircraftDto){
        aircraftsToTurnaround.add(aircraftDto);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        loadingSupervisors.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : loadingSupervisors){
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        loadingSupervisors.remove(observer);
    }
}
