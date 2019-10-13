package com.irems.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")

public class Flight {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String company;
	private LocalDateTime estimatedDeparture;
	private LocalDateTime departure;
	private LocalDateTime arrival;
	
	public Flight() {
		super();
	}
	/**
	 * @param id
	 * @param company
	 * @param estimatedDeparture
	 * @param departure
	 * @param arrival
	 */
	public Flight(int id, String company, LocalDateTime estimatedDeparture, LocalDateTime departure,
			LocalDateTime arrival) {
		super();
		this.id = id;
		this.company = company;
		this.estimatedDeparture = estimatedDeparture;
		this.departure = departure;
		this.arrival = arrival;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the estimatedDeparture
	 */
	public LocalDateTime getEstimatedDeparture() {
		return estimatedDeparture;
	}
	/**
	 * @param estimatedDeparture the estimatedDeparture to set
	 */
	public void setEstimatedDeparture(LocalDateTime estimatedDeparture) {
		this.estimatedDeparture = estimatedDeparture;
	}
	/**
	 * @return the departure
	 */
	public LocalDateTime getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}
	/**
	 * @return the arrival
	 */
	public LocalDateTime getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	
}
