package com.airport.domain.loadingSupervisor;

import lombok.Getter;

@Getter
public class LoadingSupervisorDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;

    public LoadingSupervisorDto(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
}
