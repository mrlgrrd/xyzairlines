package com.capgemini.xyzairlines.models;

import javax.persistence.*;

@Entity
public class Airplane {
    /**
     * properties
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String type;

    private int fuel;

    @ManyToOne
    private Airport airport;

    /**
     * default constructor
     */
    public Airplane() {
    }

    public Airplane(String name, String type, int fuel, Airport airport) {
        this.name = name;
        this.type = type;
        this.fuel = fuel;
        this.airport = airport;
    }

    public Airplane(String name, String type, int fuel) {
        this.name = name;
        this.type = type;
        this.fuel = fuel;
    }

    public Airplane(String name, String type) {
        this.name = name;
        this.type = type;
        this.fuel = 5;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public long getId() {
        return id;
    }
}
