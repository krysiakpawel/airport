package com.airport.domain.weather;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity(name = "WEATHER")
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime time;
    private int windSpeed;
    private String windDirection;
    private int temperature;

    public Weather(LocalDateTime time, int windSpeed, String windDirection, int temperature){
        this.time = LocalDateTime.now();
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.temperature = temperature;
    }

}
