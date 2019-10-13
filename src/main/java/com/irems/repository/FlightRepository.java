package com.irems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightRepository, Integer> {
	
	@Override
	public Optional<FlightRepository> findById(Integer id);

}
