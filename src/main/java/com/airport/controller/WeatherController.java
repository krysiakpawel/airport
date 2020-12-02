package com.airport.controller;

import com.airport.mapper.WeatherMapper;
import com.airport.client.openweathermap.OpenWeatherMapClient;
import com.airport.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @Autowired
    WeatherMapper weatherMapper;

    @Autowired
    private OpenWeatherMapClient openWeatherMapClient;


    @Scheduled(cron = "0 0/5 * * * *")
    @GetMapping(value = "saveActualWeather")
    public void saveActualWeather() {
        weatherService.saveWeather(weatherMapper.mapToWeather(openWeatherMapClient.getWeather()));
    }

    @GetMapping(value = "getLatestWeather")
    public String getLatestWeather() throws SQLException {
        return weatherService.getLatestWeather().toString();
    }

    @DeleteMapping(value = "deleteWeather")
    public void deleteWeather(@RequestParam Long id){
        weatherService.deleteWeather(id);
    }
}
