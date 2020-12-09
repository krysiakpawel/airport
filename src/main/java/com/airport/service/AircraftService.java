package com.airport.service;

import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.dao.AircraftDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {

    @Autowired
    private AircraftDao aircraftDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(AircraftService.class);

    public Aircraft saveAircraft(final Aircraft aircraft) {
        if (aircraft != null) {
            return aircraftDao.save(aircraft);
        }
        return new Aircraft();
    }

    public void deleteAircraftByFlightNumber(String flightNumber) {
        aircraftDao.deleteByFlightNumber(flightNumber);
    }

    public Aircraft getFlight(String flightNumber) {

        try {
            Aircraft aircraft = aircraftDao.findAircraftByFlightNumber(flightNumber);
            LOGGER.info("Getting flight " + flightNumber);
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not find desirable flight. Error: " + e.getMessage());
            return new Aircraft();
        }
    }

    public Aircraft setPassengerStatus(int status, String flightNumber) {

        try {
            Aircraft aircraft = getFlight(flightNumber);
            aircraft.setPassengerStatus(status);
            LOGGER.info("Passenger status for flight " + flightNumber + " has been change successfully.");
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not change passenger status for flight " + flightNumber + ". Error: ", e.getMessage());
            return new Aircraft();
        }
    }

    public Aircraft setCargoStatus(int status, String flightNumber) {
        try {
            Aircraft aircraft = getFlight(flightNumber);
            aircraft.setCargoStatus(status);
            LOGGER.info("Cargo status for flight " + flightNumber + " has been change successfully.");
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not change cargo status for flight " + flightNumber + ". Error: ", e.getMessage());
            return new Aircraft();

        }
    }

    public Aircraft setCleaningStatus(int status, String flightNumber) {

        try {
            Aircraft aircraft = getFlight(flightNumber);
            aircraft.setCleaningStatus(status);
            LOGGER.info("Cleaning status for flight " + flightNumber + " has been change successfully.");
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not change cleaning status for flight " + flightNumber + ". Error: ", e.getMessage());
            return new Aircraft();
        }
    }

    public Aircraft setMaintenanceStatus(int status, String flightNumber) {

        try {
            Aircraft aircraft = getFlight(flightNumber);
            aircraft.setMaintenanceStatus(status);
            LOGGER.info("Maintenance status for flight " + flightNumber + " has been change successfully.");
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not change maintenance status for flight " + flightNumber + ". Error: ", e.getMessage());
            return new Aircraft();
        }
    }

    public Aircraft setFuelingStatus(int status, String flightNumber) {
        try {
            Aircraft aircraft = getFlight(flightNumber);
            aircraft.setFuelingStatus(status);
            LOGGER.info("Fueling status for flight " + flightNumber + " has been change successfully.");
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not change fueling status for flight " + flightNumber + ". Error: ", e.getMessage());
            return new Aircraft();
        }
    }

    public Aircraft setCateringStatus(int status, String flightNumber) {
        try {
            Aircraft aircraft = getFlight(flightNumber);
            aircraft.setCateringStatus(status);
            LOGGER.info("Catering status for flight " + flightNumber + " has been change successfully.");
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not change catering status for flight " + flightNumber + ". Error: ", e.getMessage());
            return new Aircraft();
        }
    }

    public Aircraft setFlightStatus(String status, String flightNumber) {
        try {
            Aircraft aircraft = getFlight(flightNumber);
            aircraft.setFlightStatus(status);
            LOGGER.info("Flight status for flight " + flightNumber + " has been change successfully.");
            return aircraft;
        } catch (Exception e) {
            LOGGER.error("Could not change flight status for flight " + flightNumber + ". Error: ", e.getMessage());
            return new Aircraft();
        }
    }

    public String getAircraftStatus(String flightNumber) {
        try {
            Aircraft aircraft = getFlight(flightNumber);
            LOGGER.info("Flight status for flight " + flightNumber + " has been change successfully.");
            return aircraft.toString();
        } catch (Exception e) {
            LOGGER.error("Could not get flight " + flightNumber + ". Error: ", e.getMessage());
            return "Error";
        }
    }

    public Aircraft checkStatus(String flightNumber) {
        try {
            Aircraft aircraft = getFlight(flightNumber);
            LOGGER.info("Checking flight " + flightNumber + " statuses..");
            if (aircraft.getPassengerStatus() == 3 &&
                    aircraft.getCargoStatus() == 3 &&
                    aircraft.getCleaningStatus() == 3 &&
                    aircraft.getMaintenanceStatus() == 3 &&
                    aircraft.getFuelingStatus() == 3 &&
                    aircraft.getCateringStatus() == 3) {
                aircraft.setIsReady(true);
                LOGGER.info("Plane is ready for push back.");
                return aircraft;
            }
            if (aircraft.getPassengerStatus() != 3) {
                aircraft.setIsReady(false);
                return aircraft;
            }
            if (aircraft.getCargoStatus() != 3) {
                aircraft.setIsReady(false);
                return aircraft;
            }
            if (aircraft.getCleaningStatus() != 3) {
                aircraft.setIsReady(false);
                return aircraft;
            }
            if (aircraft.getMaintenanceStatus() != 0 && aircraft.getMaintenanceStatus() != 3) {
                aircraft.setIsReady(false);
                return aircraft;
            }
            if (aircraft.getFuelingStatus() != 3) {
                aircraft.setIsReady(false);
                return aircraft;
            }
            if (aircraft.getCateringStatus() != 3) {
                aircraft.setIsReady(false);
                return aircraft;
            }
        } catch (Exception e) {
            LOGGER.error("Could not perform status check on flight " + flightNumber + ". Error: " + e.getMessage());
        }
        return null;
    }


    public String planeOnTaxiway(String flightNumber) {
        try {
            Aircraft aircraft = getFlight(flightNumber);
            boolean isReadyToDelete = aircraft.getIsReady();
            if (isReadyToDelete) {
                deleteAircraftByFlightNumber(flightNumber);
            } else {
                return "Plane can not be deleted yet, it is still on gate!";
            }
        } catch (Exception e) {
            return "Problem during deleting aircraft occurred!";
        }
        return null;
    }
}
