package com.airport.mapper;

import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import com.airport.domain.loadingSupervisor.LoadingSupervisorDto;
import org.springframework.stereotype.Component;

@Component
public class LoadingSupervisorMapper {

    public static LoadingSupervisorDto mapToLoadingSupervisorDto(final LoadingSupervisor loadingSupervisor){
        return new LoadingSupervisorDto(loadingSupervisor.getName(), loadingSupervisor.getLastName(), loadingSupervisor.getEmail());
    }

    public static LoadingSupervisor mapToLoadingSupervisor(final LoadingSupervisorDto loadingSupervisorDto){
        return new LoadingSupervisor(loadingSupervisorDto.getName(),loadingSupervisorDto.getLastName(), loadingSupervisorDto.getEmail());
    }
}

