package com.capgemini.xyzairlines.services;

import com.capgemini.xyzairlines.models.Airplane;
import com.capgemini.xyzairlines.repositories.AirplaneRepository;
import com.capgemini.xyzairlines.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return airplaneRepository.findAll();
    }
}
