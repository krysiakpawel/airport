package com.airport.client.openweathermap;


import com.airport.domain.weather.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class OpenWeatherMapClient {

    @Value("${openweathermap.endpoint.api.prod}")
    private String openWeatherMapEndpoint;

    @Value("${openweathermap.app.key}")
    private String openWeatherMapKey;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherDto getWeather() {

        URI uri = UriComponentsBuilder.fromHttpUrl(openWeatherMapEndpoint + "weather")
                .queryParam("q", "Keflavik")
                .queryParam("units", "metric")
                .queryParam("appid", openWeatherMapKey).build().encode().toUri();

        WeatherDto weatherResponse = restTemplate.getForObject(uri, WeatherDto.class);
        return weatherResponse;

    }
}
