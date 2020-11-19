package com.airport.controller;

import com.airport.domain.loadingSupervisor.LoadingSupervisorDto;
import com.airport.mapper.LoadingSupervisorMapper;
import com.airport.service.LoadingSupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/loadingsupervisor")
public class LoadingSupervisorController {

    @Autowired
    private LoadingSupervisorService loadingSupervisorService;
    @Autowired
    private LoadingSupervisorMapper loadingSupervisorMapper;


    @PostMapping(value = "createLoadingSupervisor")
    public void createLoadingSupervisor(@RequestBody LoadingSupervisorDto loadingSupervisorDto){
        loadingSupervisorService.saveLoadingSupervisor(
                loadingSupervisorMapper.mapToLoadingSupervisor(loadingSupervisorDto));
    }

}