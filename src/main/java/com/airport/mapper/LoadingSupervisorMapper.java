package com.airport.mapper;

import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import com.airport.domain.loadingSupervisor.LoadingSupervisorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoadingSupervisorMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadingSupervisorMapper.class);

    public static LoadingSupervisorDto mapToLoadingSupervisorDto(final LoadingSupervisor loadingSupervisor) {
        try {
            return new LoadingSupervisorDto(loadingSupervisor.getName(),
                    loadingSupervisor.getLastName(),
                    loadingSupervisor.getEmail());
        } catch (Exception e) {
            LOGGER.error("Could not map LoadingSupervisor to LoadingSupervisorDto. Error: ", e);
            return null;
        }
    }

    public static LoadingSupervisor mapToLoadingSupervisor(final LoadingSupervisorDto loadingSupervisorDto) {
        try {
            return new LoadingSupervisor(loadingSupervisorDto.getName(),
                    loadingSupervisorDto.getLastName(),
                    loadingSupervisorDto.getEmail());
        } catch (Exception e) {
            LOGGER.error("Could not map LoadingSupervisorDto to LoadingSupervisor. Error: ", e);
            return null;
        }
    }
}

