package com.airport.controller;


import com.airport.domain.weather.WeatherDto;
import com.airport.mapper.WeatherMapper;
import com.airport.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @Autowired
    WeatherMapper weatherMapper;

    @PostMapping(value = "saveWeather")
    public void saveWeather(@RequestBody final WeatherDto weatherDto){
        weatherService.saveWeather(weatherMapper.mapToWeather(weatherDto));
    }

    @DeleteMapping(value = "deleteWeather")
    public void deleteWeather(@RequestParam Long id){
        weatherService.deleteWeather(id);
    }
}
