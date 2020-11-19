package com.airport.mapper;

import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import com.airport.domain.loadingSupervisor.LoadingSupervisorDto;
import org.springframework.stereotype.Component;

@Component
public class LoadingSupervisorMapper {

    public LoadingSupervisorDto mapToLoadingSupervisorDto(final LoadingSupervisor loadingSupervisor){
        return new LoadingSupervisorDto(loadingSupervisor.getName(), loadingSupervisor.getLastname());
    }

    public LoadingSupervisor mapToLoadingSupervisor(final LoadingSupervisorDto loadingSupervisorDto){
        return new LoadingSupervisor(loadingSupervisorDto.getName(),loadingSupervisorDto.getLastname());
    }
}

