package com.airport.mapper;

import com.airport.domain.weather.Weather;
import com.airport.domain.weather.WeatherDto;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public Weather mapToWeather(final WeatherDto weatherDto) {
        return new Weather(
                weatherDto.getWind().getSpeed(),
                weatherDto.getWind().getDeg(),
                weatherDto.getMain().getTemp()
        );
    }
}

