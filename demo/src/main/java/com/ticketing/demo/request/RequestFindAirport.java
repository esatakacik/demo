package com.ticketing.demo.request;

import java.time.LocalDateTime;

public class RequestFindAirport {
	
	private LocalDateTime date;
	private String boardingAirportName;
	private String destinationAirportName;
	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	/**
	 * @return the boardingAirportName
	 */
	public String getBoardingAirportName() {
		return boardingAirportName;
	}
	/**
	 * @param boardingAirportName the boardingAirportName to set
	 */
	public void setBoardingAirportName(String boardingAirportName) {
		this.boardingAirportName = boardingAirportName;
	}
	/**
	 * @return the destinationAirportName
	 */
	public String getDestinationAirportName() {
		return destinationAirportName;
	}
	/**
	 * @param destinationAirportName the destinationAirportName to set
	 */
	public void setDestinationAirportName(String destinationAirportName) {
		this.destinationAirportName = destinationAirportName;
	}
}
