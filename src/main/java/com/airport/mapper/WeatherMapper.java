package com.airport.mapper;

import com.airport.domain.weather.Main;
import com.airport.domain.weather.Weather;
import com.airport.domain.weather.WeatherDto;
import com.airport.domain.weather.Wind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherMapper.class);

    public static Weather mapToWeather(final WeatherDto weatherDto) {
        try {
            return new Weather(
                    weatherDto.getWind().getSpeed(),
                    weatherDto.getWind().getDeg(),
                    weatherDto.getMain().getTemp());
        } catch (Exception e) {
            LOGGER.error("Could not map weatherDto to weather. Error: ", e);
            return null;
        }
    }

    public static WeatherDto mapToWeatherDto(final Weather weather) {
        try {
            return new WeatherDto(
                    new Wind(weather.getWindSpeed(), weather.getWindDirection()),
                    new Main(weather.getTemp()));
        } catch (Exception e) {
            LOGGER.error("Could not map weather to mweatherDto. Error: ", e);
            return null;
        }
    }
}

