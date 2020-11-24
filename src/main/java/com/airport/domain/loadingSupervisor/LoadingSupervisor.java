package com.airport.domain.loadingSupervisor;

import com.airport.domain.aircraft.Aircraft;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "LOADING_SUPERVISOR")
@NoArgsConstructor
public class LoadingSupervisor {

    private Long id;
    private String name;
    private String lastName;
    private List<Aircraft> aircraftList = new ArrayList<>();

    public LoadingSupervisor(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @Column(name = "SUPERVISOR_ID")
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Column(name = "LASTNAME")
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @OneToMany(
            targetEntity = Aircraft.class,
            mappedBy = "loadingSupervisor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Aircraft> getAircraftList(){
        return aircraftList;
    }
    private void setAircraftList(List<Aircraft> aircraftList){
        this.aircraftList = aircraftList;
    }
}
