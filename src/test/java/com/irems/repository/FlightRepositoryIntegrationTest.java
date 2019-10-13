package com.irems.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.LocalDateTimeType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.irems.entity.Flight;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private FlightRepository flightRepository;
	
	private Flight flight = new Flight(
			"TestCompany",
			LocalDateTime.of(2019, 05, 05, 10, 0, 5),
			LocalDateTime.of(2019, 05, 05, 10, 0, 5),
			LocalDateTime.of(2019, 05, 05, 11, 0, 0)
	);
	
	@Test
	public void findById_FlightReturnedByIdOfExistingFlight() {
		entityManager.persist(flight);
		entityManager.flush();
		Optional<Flight> found = flightRepository.findById(flight.getId());
		assertEquals(flight, found.get());
	}

	@Test
	public void save_FlightReturnedByIdOfSavedFlight() {
		flightRepository.save(flight);
		Optional<Flight> found = flightRepository.findById(flight.getId());
		assertEquals(flight, found.get());
	}
	
	@Test
	public void save_UpdatedFlightSavedAndReturned() {
		flightRepository.save(flight);
		flight.setCompany("UpdatedCompany");
		flightRepository.save(flight);
		Optional<Flight> found = flightRepository.findById(flight.getId());
		assertEquals(flight, found.get());
	}
	
	@Test
	public void deleteById_NoFlightReturnedByIdOfDeletedFlight() {
		entityManager.persist(flight);
		entityManager.flush();
		flightRepository.deleteById(flight.getId());
		Optional<Flight> found = flightRepository.findById(flight.getId());
		assertTrue(found.isEmpty());
	}

	@Test
	public void findAll_ReturnAllFlights() {
		Flight anotherFlight = new Flight(
				"AnotherCompany",
				LocalDateTime.of(2019, 05, 05, 10, 0, 5),
				LocalDateTime.of(2019, 05, 05, 10, 0, 5),
				LocalDateTime.of(2019, 05, 05, 11, 0, 0)
		);
		flightRepository.save(anotherFlight);
		flightRepository.save(flight);
		List<Flight> fligths = flightRepository.findAll();
		assertTrue(fligths.size() == 2);
	}
}
