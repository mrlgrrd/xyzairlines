package com.capgemini.xyzairlines.controllers;

import com.capgemini.xyzairlines.models.Airport;
import com.capgemini.xyzairlines.services.AirplaneService;
import com.capgemini.xyzairlines.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airportcontroller/")
public class AirportController {

    // auto connected airplane service
    @Autowired
    private AirplaneService airplaneService;

    // auto connecter airport service
    @Autowired
    private AirportService airportService;

    @RequestMapping(value = "getairports", method = RequestMethod.GET)
    public Iterable<Airport> getAirports(){
        return this.airportService.allAirports();
    }



}
