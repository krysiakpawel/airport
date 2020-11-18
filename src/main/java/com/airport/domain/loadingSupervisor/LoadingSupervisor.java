package com.airport.domain.loadingSupervisor;


import com.airport.domain.aircraft.Aircraft;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class LoadingSupervisor {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "AIRCRAFT_ID", referencedColumnName = "AIRCRAFT_ID")
//    private Aircraft aircraft;


}
