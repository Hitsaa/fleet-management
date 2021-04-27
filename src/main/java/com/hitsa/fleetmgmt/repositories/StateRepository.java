package com.hitsa.fleetmgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hitsa.fleetmgmt.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
