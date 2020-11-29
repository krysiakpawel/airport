package com.airport.observer;

import com.airport.domain.aircraft.Aircraft;

public interface Observer {

    void update(Aircraft aircraft);
}
