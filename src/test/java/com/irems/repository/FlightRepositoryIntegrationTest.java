package com.irems.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.type.LocalDateTimeType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.irems.entity.Flight;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void findById_FlightReturnedByIdOfExistingFlight() {
		// given

		Flight flight = new Flight("TestCompany", LocalDateTime.of(2019, 05, 05, 10, 0, 5),
				LocalDateTime.of(2019, 05, 05, 10, 0, 5), LocalDateTime.of(2019, 05, 05, 10, 30, 0));
		entityManager.persist(flight);
		entityManager.flush();

		// when
		Optional<Flight> found = flightRepository.findById(flight.getId());

		// then
		assertEquals(flight, found.get());
	}

}
