package com.airport.mapper;


import com.airport.domain.weather.Weather;
import com.airport.domain.weather.WeatherDto;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public Weather mapToWeather(final WeatherDto weatherDto){
        return new Weather(
                weatherDto.getTime(),
                weatherDto.getWindSpeed(),
                weatherDto.getWindDirection(),
                weatherDto.getTemperature());
    }

    public WeatherDto mapToWeatherDto(final Weather weather){
        return new WeatherDto(
                weather.getTime(),
                weather.getWindSpeed(),
                weather.getWindDirection(),
                weather.getTemperature());

    }
}
