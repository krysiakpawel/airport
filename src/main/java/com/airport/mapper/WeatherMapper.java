package com.airport.mapper;

import com.airport.domain.weather.Main;
import com.airport.domain.weather.Weather;
import com.airport.domain.weather.WeatherDto;
import com.airport.domain.weather.Wind;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public static Weather mapToWeather(final WeatherDto weatherDto) {
        return new Weather(
                weatherDto.getWind().getSpeed(),
                weatherDto.getWind().getDeg(),
                weatherDto.getMain().getTemp()
        );
    }

    public static WeatherDto mapToWeatherDto(final Weather weather){
        return new WeatherDto(
                new Wind(weather.getWindSpeed(),weather.getWindDirection()),
                new Main(weather.getTemp()));
    }
}

