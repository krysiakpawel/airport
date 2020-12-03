package com.airport.service;


import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import com.airport.domain.loadingSupervisor.dao.LoadingSupervisorDao;
import com.airport.domain.mail.Mail;
import com.airport.mapper.AircraftMapper;
import com.airport.mapper.LoadingSupervisorMapper;
import com.airport.observer.AircraftsToTurnaround;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadingSupervisorService {

    @Autowired
    LoadingSupervisorDao loadingSupervisorDao;

    @Autowired
    AircraftService aircraftService;

    @Autowired
    EmailService emailService;

    private AircraftsToTurnaround aircraftsToTurnaround;
    private static final String SUBJECT = "New aircraft for turnaround";

    public LoadingSupervisor saveLoadingSupervisor(final LoadingSupervisor loadingSupervisor) {
        return loadingSupervisorDao.save(loadingSupervisor);
    }

    public void deleteLoadingSupervisor(Long id) {
        loadingSupervisorDao.deleteById(id);
    }

    public LoadingSupervisor getLoadingSupervisor(long id) {
        LoadingSupervisor loadingSupervisor = loadingSupervisorDao.findById(id).get();
        return loadingSupervisor;
    }

    public Aircraft assignAircraft(Long id, String flightNumber) {
        LoadingSupervisor loadingSupervisor = getLoadingSupervisor(id);
        Aircraft aircraft = aircraftService.getFlight(flightNumber);
        aircraft.setLoadingSupervisor(loadingSupervisor);
        loadingSupervisor.getAircraftList().add(aircraft);
        aircraftService.saveAircraft(aircraft);
        saveLoadingSupervisor(loadingSupervisor);
        aircraftsToTurnaround.registerObserver(LoadingSupervisorMapper.mapToLoadingSupervisorDto(loadingSupervisor));
        aircraftsToTurnaround.addAircraft(AircraftMapper.mapToAircraftDto(aircraft));
        aircraftsToTurnaround.notifyObservers();
        emailService.send(new Mail(loadingSupervisor.getEmail(), SUBJECT,
                "New aircraft for turnaround from " + aircraft.getAirline() +
                        ". Flight number " + aircraft.getFlightNumber() + ". Flight status: " +
                        aircraft.getFlightStatus() + " at " + aircraft.getETA() + " on gate " + aircraft.getGate() + "."));
        return aircraft;
    }
}