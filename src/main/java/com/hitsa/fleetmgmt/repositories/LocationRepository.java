package com.hitsa.fleetmgmt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hitsa.fleetmgmt.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
