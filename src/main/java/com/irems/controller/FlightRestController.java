package com.irems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irems.dto.FlightDto;
import com.irems.entity.Flight;
import com.irems.service.FlightService;

@RestController
public class FlightRestController {
 
    @Autowired
    private FlightService flightService;
 
    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightService.findAll();
    }
    
    @PostMapping("/flights")
    public void createFlight(@RequestBody FlightDto flightDto) {
    	Flight flight = new Flight(
    			flightDto.getCompany(),
    			flightDto.getEstimatedDeparture(),
    			flightDto.getDeparture(),
    			flightDto.getArrival()
    	);
    	flightService.save(flight);
    }
    
    @PutMapping("/flights")
    public void updateFlight(@RequestBody FlightDto flightDto) {
    	Optional <Flight> flight = flightService.findById(flightDto.getId());
    	if(flight.isPresent()) {
    		flight.get().setCompany(flightDto.getCompany());
        	flightService.save(flight.get());
    	}	
    }
    
    @DeleteMapping("/flights/{id}")
    public void deleteFlight(@RequestParam int id) {
        flightService.deleteById(id);
    }

}