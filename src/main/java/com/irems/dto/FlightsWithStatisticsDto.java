package com.irems.dto;

import java.util.ArrayList;
import java.util.List;

import com.irems.entity.Flight;

public class FlightsWithStatisticsDto {
	private List<Flight> flights = new ArrayList<>();
	private Statistics statistics;

	public FlightsWithStatisticsDto(List<Flight> flights, Statistics statistics) {
		super();
		this.flights = flights;
		this.statistics = statistics;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public static class Statistics {
		private double averageDelay;
		private double maxDelay;

		public double getAverageDelay() {
			return averageDelay;
		}

		public void setAverageDelay(double averageDelay) {
			this.averageDelay = averageDelay;
		}

		public double getMaxDelay() {
			return maxDelay;
		}

		public void setMaxDelay(double maxDelay) {
			this.maxDelay = maxDelay;
		}

		public Statistics(double averageDelay, double maxDelay) {
			super();
			this.averageDelay = averageDelay;
			this.maxDelay = maxDelay;
		}
	}
}
