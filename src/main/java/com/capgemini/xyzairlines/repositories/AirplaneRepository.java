package com.capgemini.xyzairlines.repositories;

import com.capgemini.xyzairlines.models.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long>{


}
