package com.capgemini.xyzairlines.repositories;

import com.capgemini.xyzairlines.models.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long>{
}
