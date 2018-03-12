package com.capgemini.xyzairlines.services;

import com.capgemini.xyzairlines.models.Airplane;
import com.capgemini.xyzairlines.models.Airport;
import com.capgemini.xyzairlines.repositories.AirplaneRepository;
import com.capgemini.xyzairlines.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    /**
     * default constructor
     */
    public AirplaneService() {
    }

    /**
     * creates an interable of all registered airplanes
     * @return iterable of all airplanes
     */
    public Iterable<Airplane> allPlanes(){
        return this.airplaneRepository.findAll();
    }

    public void deletePlane(Long id){
        this.airplaneRepository.delete(id);
    }

    /**
     * this method sets the fuelreserve of the plane to 5
     * @param id id of the plane
     */
    public void tankAirplane(Long id) {
        Airplane plane = this.airplaneRepository.findOne(id);
        plane.setFuel(5);

    }

    /**
     * this method updates the location of the plane + updates the fuel reserve.
     * @param id id of the plane
     */
    public void flyAirplane(Long id, Long airportId) {
        Airplane plane = this.airplaneRepository.findOne(id);
        if(plane.getFuel() <= 2){
            Airport airport = this.airportRepository.findOne(airportId);
            plane.setAirport(airport);
            plane.setFuel(plane.getFuel() - 2);
        }

    }

    public void save(Airplane plane) {
        this.airplaneRepository.save(plane);
    }
}
