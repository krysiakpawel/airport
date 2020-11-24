package com.airport.client.aviationstack;

import com.airport.domain.aircraft.AircraftDto;
import com.airport.domain.aircraft.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class AviationStackClient {

    @Value("${aviationstack.endpoint.api.prod}")
    private String aviationStackEndpoint;

    @Value("${aviationstack.app.key}")
    private String aviationStackKey;


    @Autowired
    private RestTemplate restTemplate;

    public List<AircraftDto> getLandedAircrafts() {

        URI uri = UriComponentsBuilder.fromHttpUrl(aviationStackEndpoint + "flights")
                .queryParam("access_key", aviationStackKey)
                .queryParam("arr_iata", "kef")
                .queryParam("flight_status","landed")
                .queryParam("limit", "1").build().encode().toUri();

        Data aircraftResponse[] = restTemplate.getForObject(uri, Data[].class);
//        return aircraftResponse;

        if (aircraftResponse != null) {
            List<AircraftDto> aircrafts = new ArrayList<>();
            for(Data data : aircraftResponse){
                for(AircraftDto aircraftDto : AircraftDto[])

            }
        }
        return new ArrayList<>();
    }
}
