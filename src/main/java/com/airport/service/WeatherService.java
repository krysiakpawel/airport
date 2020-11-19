package com.airport.service;

import com.airport.domain.weather.Weather;
import com.airport.domain.weather.dao.WeatherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private WeatherDao weatherDao;

    public Weather saveWeather(final Weather weather){
        return weatherDao.save(weather);
    }
     public void deleteWeather(Long id){
        weatherDao.deleteById(id);
     }
}
