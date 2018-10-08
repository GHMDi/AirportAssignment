package com.setrackgeert.AirportAssignment.AirportAssignment.repository;

import com.setrackgeert.AirportAssignment.AirportAssignment.models.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository <Airplane, Long> {
}
