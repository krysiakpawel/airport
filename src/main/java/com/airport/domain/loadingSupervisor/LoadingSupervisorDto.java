package com.airport.domain.loadingSupervisor;


import com.airport.domain.aircraft.Aircraft;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class LoadingSupervisorDto {

    private Long id;
    private String name;
    private String lastname;
//    private List<Aircraft> aircrafts;

    public LoadingSupervisorDto(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
//        this.aircrafts = new ArrayList<>();
    }
}
