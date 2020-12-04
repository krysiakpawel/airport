package com.airport.domain.weather;
;
import lombok.AllArgsConstructor;
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

    @Column(name = "WIND_SPEED_M_PER_SEC")
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

    public String toString() {
        String weatherInfo;
        if (getWindSpeed() > 15.4) {
            weatherInfo = "Aviation Weather Warning! Surface wind exceeds 30 knots.";
        } else {
            weatherInfo = "Weather is acceptable for further aviation operations";
        }
        return "Weather measured at " + getTime() + ": \n" +
                "Temperature: " + getTemp() + ";\n" +
                "Wind: " + getWindSpeed() + " m/s at direction of " + getWindDirection() + ".\n"
                + weatherInfo;
    }
}
