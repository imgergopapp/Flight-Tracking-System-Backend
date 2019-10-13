package com.irems.service.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.irems.entity.Flight;
import com.irems.repository.FlightRepository;
import com.irems.service.FlightService;

@RunWith(SpringRunner.class)
public class SimpleFlightServiceIntegrationTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public FlightService flightService() {
			return new SimpleFlightService();
		}
	}

	@Autowired
	private FlightService flightService;

	@MockBean
	private FlightRepository flightRepository;

	private Flight flight;

	@Before
	public void SetUp() {
		flight = new Flight(
				"TestCompany",
				LocalDateTime.of(2019, 05, 05, 10, 0, 5),
				LocalDateTime.of(2019, 05, 05, 10, 0, 5),
				LocalDateTime.of(2019, 05, 05, 11, 0, 0)
		);
		flightService.save(flight);
	}

	@Test
	public void save_FlightSavedAndReturnedById() {
		Optional<Flight> found = flightService.findById(flight.getId());
		assertEquals(flight, found.get());
	}

	@Test
	public void save_UpdatedFlightSavedAndReturned() {
		flight.setCompany("UpdatedCompany");
		flightService.save(flight);
		Optional<Flight> found = flightService.findById(flight.getId());
		assertEquals(flight, found.get());
	}

	@Test
	public void deleteById_NoFlightReturnedByIdOfDeletedFlight() {
		flightService.deleteById(flight.getId());
		Optional<Flight> found = flightService.findById(flight.getId());
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
		flightService.save(anotherFlight);
		List<Flight> fligths = flightService.findAll();
		assertTrue(fligths.size() == 2);
	}
}
