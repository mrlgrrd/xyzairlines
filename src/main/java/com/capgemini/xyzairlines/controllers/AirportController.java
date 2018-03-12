package com.capgemini.xyzairlines.controllers;

import com.capgemini.xyzairlines.models.Airplane;
import com.capgemini.xyzairlines.models.Airport;
import com.capgemini.xyzairlines.services.AirplaneService;
import com.capgemini.xyzairlines.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "deleteairport", method = RequestMethod.DELETE)
    public void deleteAirport(Long id){
        this.airportService.deleteAirport(id);
    }

    @RequestMapping(value = "newairport", method = RequestMethod.POST)
    public void newAirport(@RequestBody Airport airport){
        this.airportService.save(airport);
    }

    @RequestMapping(value = "getairplanes", method = RequestMethod.GET)
    public Iterable<Airplane> getAirplanes(){
        return this.airplaneService.allPlanes();
    }

    @RequestMapping(value = "deleteairplane", method = RequestMethod.DELETE)
    public void deleteAirplane(Long id){
        this.airplaneService.deletePlane(id);
    }

    @RequestMapping(value = "tankplane", method = RequestMethod.PUT)
    public void tankAirplane(Long id){
        this.airplaneService.tankAirplane(id);

    }

    @RequestMapping(value = "flyplane", method = RequestMethod.PUT)
    public void flyAirplane(Long id, Long airportId){
        this.airplaneService.flyAirplane(id, airportId);
    }

    @RequestMapping(value = "newplane", method = RequestMethod.POST)
    public void newAirplane(@RequestBody Airplane plane ){
        this.airplaneService.save(plane);
    }



}
