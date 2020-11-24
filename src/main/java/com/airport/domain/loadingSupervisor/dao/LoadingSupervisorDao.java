package com.airport.domain.loadingSupervisor.dao;

import com.airport.domain.loadingSupervisor.LoadingSupervisor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface LoadingSupervisorDao extends CrudRepository<LoadingSupervisor, Long> {

    @Override
    LoadingSupervisor save(LoadingSupervisor loadingSupervisor);

    @Override
    void deleteById(Long id);
}
