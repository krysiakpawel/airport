package com.airport.domain.weather;
;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "WEATHER")
@NoArgsConstructor
public class Weather {


    private Long id;
    private LocalDateTime time;
    private double windSpeed;
    private int windDirection;
    private double temp;

    public Weather(double windSpeed, int windDirection, double temp){
        this.time = LocalDateTime.now();
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.temp = temp;
    }

    @Id
    @GeneratedValue
    @Column(name = "WEATHER_ID")
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Column(name = "TIME")
    public LocalDateTime getTime(){
        return time;
    }

    public void setTime(LocalDateTime time){
        this.time = LocalDateTime.now();
    }

    @Column(name = "WIND_SPD_IN_KTS")
    public double getWindSpeed(){
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }

    @Column(name = "WIND_DIR")
    public int getWindDirection(){
        return windDirection;
    }
    public void setWindDirection(int windDirection){
        this.windDirection = windDirection;
    }

    @Column(name = "TEMPERATURE")
    public double getTemp(){
        return temp;
    }
    public void setTemp(double temperature){
        this.temp = temperature;
    }
}


// pogoda z api:
//http://api.openweathermap.org/data/2.5/weather?q=Keflavik&units=metric&appid=5da5e3ff773f884ccb9b06551de599a5
