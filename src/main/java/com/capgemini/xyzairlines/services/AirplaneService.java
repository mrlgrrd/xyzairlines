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
        Airplane Plane = this.airplaneRepository.findOne(id);

    }

    /**
     * this method updates the location of the plane + updates the fuel reserve.
     * @param id id of the plane
     */
    public void flyAirplane(Long id, Airport airport) {
        Airplane Plane = this.airplaneRepository.findOne(id);

    }
}
