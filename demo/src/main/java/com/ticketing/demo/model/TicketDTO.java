package com.ticketing.demo.model;

public class TicketDTO {

	private Long id;
	private String passangerName;
	private FlightDTO flight;
	private Double price;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
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
	public FlightDTO getFlight() {
		return flight;
	}
	/**
	 * @param flight the flight to set
	 */
	public void setFlight(FlightDTO flight) {
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
