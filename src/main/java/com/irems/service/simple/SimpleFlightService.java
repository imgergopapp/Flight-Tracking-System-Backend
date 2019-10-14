package com.irems.service.simple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irems.entity.Flight;
import com.irems.repository.FlightRepository;
import com.irems.service.FlightService;

@Service
public class SimpleFlightService implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Override
	public Optional<Flight> findById(Integer id) {
		return flightRepository.findById(id);
	}

	@Override
	public void save(Flight flight) {
		flightRepository.save(flight);
	}

	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		flightRepository.deleteById(id);
	}

}
