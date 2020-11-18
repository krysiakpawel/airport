package com.airport.domain.weather;

import lombok.Getter;
import javax.persistence.*;

@Getter
@Entity(name = "WEATHER")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int windSpeed;

    @Column
    private String windDirection;

    @Column
    private int temperature;
}
