package com.irems.dto;

import java.time.LocalDateTime;

public class FlightDto {
	
	private int id;
	private String company;
	private LocalDateTime estimatedDeparture;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	
	public FlightDto() {
		super();
	}
	
	public FlightDto(int id, String company) {
		super();
		this.id = id;
		this.company = company;
	}

	public FlightDto(String company, LocalDateTime estimatedDeparture, LocalDateTime departure, LocalDateTime arrival) {
		super();
		this.company = company;
		this.estimatedDeparture = estimatedDeparture;
		this.departure = departure;
		this.arrival = arrival;
	}

	public FlightDto(int id, String company, LocalDateTime estimatedDeparture, LocalDateTime departure, LocalDateTime arrival) {
		super();
		this.id = id;
		this.company = company;
		this.estimatedDeparture = estimatedDeparture;
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public LocalDateTime getEstimatedDeparture() {
		return estimatedDeparture;
	}
	public void setEstimatedDeparture(LocalDateTime estimatedDeparture) {
		this.estimatedDeparture = estimatedDeparture;
	}
	public LocalDateTime getDeparture() {
		return departure;
	}
	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}
	public LocalDateTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}
	
	
	
	

}
