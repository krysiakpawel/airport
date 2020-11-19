package com.airport.domain.loadingSupervisor;


import com.airport.domain.aircraft.Aircraft;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "SUPERVISOR")
public class LoadingSupervisor {


    @Id
    @GeneratedValue
    @Column(name = "SUPERVISOR_ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastname;

    public LoadingSupervisor(String name, String lastname){
        this.name = name;
        this.lastname = lastname;
    }
}
