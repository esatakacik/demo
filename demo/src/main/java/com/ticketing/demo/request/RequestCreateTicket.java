package com.ticketing.demo.request;

import com.ticketing.demo.model.Flight;

public class RequestCreateTicket {

	private String passangerName;
	private Flight flight;
	private Double price;
	/**
	 * @return the passangerName
	 */
	public String getPassangerName() {
		return passangerName;
	}
	/**
	 * @param passangerName the passangerName to set
	 */
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}
	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
}
