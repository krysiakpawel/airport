package com.airport.service;

import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import com.airport.domain.loadingSupervisor.dao.LoadingSupervisorDao;
import com.airport.domain.mail.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadingSupervisorService.class);

    private static final String SUBJECT = "New aircraft for turnaround";

    public LoadingSupervisor saveLoadingSupervisor(final LoadingSupervisor loadingSupervisor) {
        try {
            if (loadingSupervisor != null) {
                LOGGER.info("Loading supervisor " + loadingSupervisor.getName() + " " + loadingSupervisor.getLastName() + " saved successfully.");
                return loadingSupervisorDao.save(loadingSupervisor);
            } else {
                return new LoadingSupervisor();
            }
        } catch (Exception e) {
            LOGGER.error("Saving error during saving loading supervisor", e.getMessage());
            return new LoadingSupervisor();
        }
    }

    public void deleteLoadingSupervisor(Long id) {
        try {
            loadingSupervisorDao.deleteById(id);
            LOGGER.info("Loading supervisor with id: " + id + " has been deleted successfully.");
        } catch (Exception e) {
            LOGGER.error("Could not find desirable loading supervisor", e.getMessage());
        }
    }

    public LoadingSupervisor getLoadingSupervisor(long id) {

        try {
            LoadingSupervisor loadingSupervisor = loadingSupervisorDao.findById(id).get();
            LOGGER.info("Getting loading supervisor.");
            return loadingSupervisor;
        } catch (Exception e) {
            LOGGER.error("Could not find loading supervisor with id " + id + ". Error: ", e.getMessage());
            return new LoadingSupervisor();
        }
    }

    public Aircraft assignAircraft(Long id, String flightNumber) {
        try {
            LoadingSupervisor loadingSupervisor = getLoadingSupervisor(id);
            Aircraft aircraft = aircraftService.getFlight(flightNumber);
            aircraft.setLoadingSupervisor(loadingSupervisor);
            LOGGER.info("Assigning flight " + flightNumber + " to " + loadingSupervisor.getName() + " " + loadingSupervisor.getLastName());
            loadingSupervisor.getAircraftList().add(aircraft);
            aircraftService.saveAircraft(aircraft);
            saveLoadingSupervisor(loadingSupervisor);
            emailService.send(new Mail(loadingSupervisor.getEmail(), SUBJECT,
                    "New aircraft for turnaround from " + aircraft.getAirline() +
                            ". Flight number " + aircraft.getFlightNumber() + ". Flight status: " +
                            aircraft.getFlightStatus() + " at " + aircraft.getETA() + " on gate " + aircraft.getGate() + "."));
            LOGGER.info("Assigning completed.");
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not assign flight " + flightNumber + ". Error: ", e.getMessage());
            return new Aircraft();
        }
    }
}