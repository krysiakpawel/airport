package com.airport.client.openweathermap;

import com.airport.domain.weather.WeatherDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public WeatherDto getWeather() {

        LOGGER.info("connecting to OpenWeatherMap...");
        URI uri = UriComponentsBuilder.fromHttpUrl(openWeatherMapEndpoint + "weather")
                .queryParam("q", "Keflavik")
                .queryParam("units", "metric")
                .queryParam("appid", openWeatherMapKey).build().encode().toUri();

        try {
            WeatherDto weatherResponse = restTemplate.getForObject(uri, WeatherDto.class);
            LOGGER.info("Current weather data import successful.");
            return weatherResponse;

        } catch (Exception e) {
            LOGGER.error("Could not import current weather data", e.getMessage());
            return new WeatherDto();
        }
    }
}
