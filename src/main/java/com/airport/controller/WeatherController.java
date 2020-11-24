package com.airport.controller;


import com.airport.mapper.WeatherMapper;
import com.airport.client.openweathermap.OpenWeatherMapClient;
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

    @Autowired
    private OpenWeatherMapClient openWeatherMapClient;


    @GetMapping(value = "saveActualWeather")
    public void saveActualWeather() {
        System.out.println(openWeatherMapClient.getWeather().getMain().getTemp());
        weatherService.saveWeather(weatherMapper.mapToWeather(openWeatherMapClient.getWeather()));
    }

    @DeleteMapping(value = "deleteWeather")
    public void deleteWeather(@RequestParam Long id){
        weatherService.deleteWeather(id);
    }
}
