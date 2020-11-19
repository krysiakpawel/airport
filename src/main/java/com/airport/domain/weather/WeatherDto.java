package com.airport.domain.weather;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class WeatherDto {

    private Long id;
    private LocalDateTime time;
    private int windSpeed;
    private String windDirection;
    private int temperature;

    public WeatherDto(LocalDateTime time, int windSpeed, String windDirection, int temperature) {
        this.time = LocalDateTime.now();
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.temperature = temperature;
    }
}
