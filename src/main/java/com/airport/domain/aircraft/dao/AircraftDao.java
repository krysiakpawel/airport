package com.airport.domain.aircraft.dao;

import com.airport.domain.aircraft.Aircraft;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AircraftDao extends CrudRepository <Aircraft, Long> {

    @Override
    Aircraft save (Aircraft aircraft);

    @Override
    void deleteById(Long id);
}
