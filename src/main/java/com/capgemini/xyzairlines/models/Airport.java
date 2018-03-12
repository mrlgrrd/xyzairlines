package com.capgemini.xyzairlines.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Airport {
    /**
     * properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String location;

    private int nrOfPlanes;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airport")
    private Set<Airplane> airplanes;

    /**
     * default constructor
     */
    public Airport() {
    }

    public Airport(String name, String location) {
        this.name = name;
        this.location = location;
    }

    /**
     * getters & setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNrOfPlanes() {
        return nrOfPlanes;
    }

    public void setNrOfPlanes(int nrOfPlanes) {
        this.nrOfPlanes = nrOfPlanes;
    }

    public Set<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(Set<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public long getId() {
        return id;
    }
}
