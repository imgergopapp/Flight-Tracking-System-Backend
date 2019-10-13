package com.irems.service;

import java.util.List;
import java.util.Optional;

import com.irems.entity.Flight;

public interface FlightService {
	
	
	public Optional<Flight> findById(Integer id);

	public void save(Flight flight);

	public List<Flight> findAll();

	public void deleteById(Integer id);

}
