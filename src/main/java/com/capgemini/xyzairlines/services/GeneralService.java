package com.capgemini.xyzairlines.services;

import com.capgemini.xyzairlines.models.Airplane;
import com.capgemini.xyzairlines.models.Airport;
import com.capgemini.xyzairlines.repositories.AirplaneRepository;
import com.capgemini.xyzairlines.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GeneralService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    /**
     * this methods adds the first airports and airplanes to the repositories
     */
    @PostConstruct
    private void initialisation(){
        Airport amsterdam = new Airport();
        amsterdam.setLocation("Amsterdam");
        amsterdam.setName("Schiphol Airport");
        amsterdam.setNrOfPlanes(10);
        this.airportRepository.save(amsterdam);

        Airport london = new Airport();
        london.setLocation("London");
        london.setName("London City Airport");
        london.setNrOfPlanes(10);
        this.airportRepository.save(london);

        Airport paris = new Airport();
        paris.setLocation("Paris");
        paris.setName("Charles de Gaulle int. Airport");
        paris.setNrOfPlanes(10);
        this.airportRepository.save(paris);

        Airport berlin = new Airport();
        berlin.setLocation("Berlin");
        berlin.setName("Berlin Tegel Airport");
        berlin.setNrOfPlanes(10);
        this.airportRepository.save(berlin);

        Airport stockholm = new Airport();
        stockholm.setLocation("Stockholm");
        stockholm.setName("Stockholm Arlanda Airport");
        stockholm.setNrOfPlanes(10);
        this.airportRepository.save(stockholm);

        Airplane plane1 = new Airplane("Memphis Belle", "Boeing 777", 5);
        Airplane plane2 = new Airplane("Spruce Goose", "Boeing 747", 5);
        Airplane plane3 = new Airplane("Cloudglider", "Boeing 737", 5);
        Airplane plane4 = new Airplane("Golden Condor", "Airbus A380", 5);
        Airplane plane5 = new Airplane("Low Hawk", "Airbus A350", 5);
        this.airplaneRepository.save(plane1);
        this.airplaneRepository.save(plane2);
        this.airplaneRepository.save(plane3);
        this.airplaneRepository.save(plane4);
        this.airplaneRepository.save(plane5);

        plane1.setAirport(berlin);
        this.airplaneRepository.save(plane1);
        plane2.setAirport(amsterdam);
        this.airplaneRepository.save(plane2);
        plane3.setAirport(london);
        this.airplaneRepository.save(plane3);
        plane4.setAirport(paris);
        this.airplaneRepository.save(plane4);
        plane5.setAirport(stockholm);
        this.airplaneRepository.save(plane5);


    }

}
