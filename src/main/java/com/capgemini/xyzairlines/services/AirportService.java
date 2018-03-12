package com.capgemini.xyzairlines.services;

import com.capgemini.xyzairlines.models.Airport;
import com.capgemini.xyzairlines.repositories.AirplaneRepository;
import com.capgemini.xyzairlines.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    /**
     * default constructor
     */
    public AirportService() {
    }

    /**
     * returns a list of all registeren airports
     */
    public Iterable<Airport> allAirports(){
        return this.airportRepository.findAll();
    }

    public void deleteAirport(Long id) {
        this.airportRepository.delete(id);
    }
}
