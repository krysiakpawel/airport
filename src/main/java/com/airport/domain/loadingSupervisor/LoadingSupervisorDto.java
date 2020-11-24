package com.airport.domain.loadingSupervisor;

import lombok.Getter;

@Getter
public class LoadingSupervisorDto {

    private Long id;
    private String name;
    private String lastName;

    public LoadingSupervisorDto(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
