package com.irems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irems.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	@Override
	public Optional<Flight> findById(Integer id);

}
