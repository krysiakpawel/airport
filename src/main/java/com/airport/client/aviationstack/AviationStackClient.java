package com.airport.client.aviationstack;

import com.airport.domain.aircraft.AircraftDto;
import com.airport.domain.aircraft.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class AviationStackClient {

    @Value("${aviationstack.endpoint.api.prod}")
    private String aviationStackEndpoint;

    @Value("${aviationstack.app.key}")
    private String aviationStackKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(AviationStackClient.class);

    @Autowired
    private RestTemplate restTemplate;

    public AircraftDto[] getData() {

        LOGGER.info("connecting to AviationStack...");
        URI uri = UriComponentsBuilder.fromHttpUrl(aviationStackEndpoint + "flights")
                .queryParam("access_key", aviationStackKey)
                .queryParam("arr_iata", "kef")
                .queryParam("flight_status", "landed").build().encode().toUri();

        try {
            Data data = restTemplate.getForObject(uri, Data.class);
            LOGGER.info("Connection established...");
            if (data.getAircraftDtoList()!= null) {
                LOGGER.info("Current flight data import successful.");
                return data.getAircraftDtoList();
            }
            LOGGER.info("No aviation data to import.");
            return null;
        } catch (Exception e){
            LOGGER.error("Could not import current aviation data. Error: ", e);
            return null;
        }
    }
}
