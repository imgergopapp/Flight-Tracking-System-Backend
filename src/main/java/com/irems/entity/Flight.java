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

	public Flight(String company, LocalDateTime estimatedDeparture, LocalDateTime departure, LocalDateTime arrival) {
		super();
		this.company = company;
		this.estimatedDeparture = estimatedDeparture;
		this.departure = departure;
		this.arrival = arrival;
	}

	public Flight(int id, String company, LocalDateTime estimatedDeparture, LocalDateTime departure,
			LocalDateTime arrival) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((estimatedDeparture == null) ? 0 : estimatedDeparture.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Flight))
			return false;
		Flight other = (Flight) obj;
		if (arrival == null) {
			if (other.arrival != null)
				return false;
		} else if (!arrival.equals(other.arrival))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (estimatedDeparture == null) {
			if (other.estimatedDeparture != null)
				return false;
		} else if (!estimatedDeparture.equals(other.estimatedDeparture))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
