package com.airport.service;


import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import com.airport.domain.loadingSupervisor.dao.LoadingSupervisorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadingSupervisorService {

    @Autowired
    LoadingSupervisorDao loadingSupervisorDao;

    public LoadingSupervisor saveLoadingSupervisor(final LoadingSupervisor loadingSupervisor){
        return loadingSupervisorDao.save(loadingSupervisor);
    }
}
