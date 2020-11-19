package com.airport.domain.weather.dao;

import com.airport.domain.weather.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface WeatherDao extends CrudRepository <Weather, Long> {

    @Override
    Weather save (Weather weather);

    @Override
    void deleteById(Long id);

}
