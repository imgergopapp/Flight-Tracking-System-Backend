package com.irems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irems.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Override
	public Optional<Flight> findById(Integer id);

	@Override
	public <S extends Flight> S save(S entity);

	@Override
	public List<Flight> findAll();

	public void deleteById(Integer id);

}
