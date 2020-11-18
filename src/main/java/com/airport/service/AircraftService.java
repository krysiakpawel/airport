package com.airport.service;


import com.airport.domain.aircraft.Aircraft;
import com.airport.domain.aircraft.dao.AircraftDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {

    @Autowired
    private AircraftDao aircraftDao;


    public Aircraft saveAircraft(final Aircraft aircraft){
        return aircraftDao.save(aircraft);
    }

    public void deleteAircraftById(Long id){
        aircraftDao.deleteById(id);
    }

}
