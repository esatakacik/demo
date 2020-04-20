package com.ticketing.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Ucus suresi
	@Column(name = "flight_time")
	private Integer flightTime;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="boarding_airport_id", referencedColumnName = "id")
	private Airport boardingAirport;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="destination_airport_id", referencedColumnName = "id")
	private Airport destinationAirport;

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
	 * @return the flightTime
	 */
	public Integer getFlightTime() {
		return flightTime;
	}

	/**
	 * @param flightTime the flightTime to set
	 */
	public void setFlightTime(Integer flightTime) {
		this.flightTime = flightTime;
	}

	/**
	 * @return the boardingAirport
	 */
	public Airport getBoardingAirport() {
		return boardingAirport;
	}

	/**
	 * @param boardingAirport the boardingAirport to set
	 */
	public void setBoardingAirport(Airport boardingAirport) {
		this.boardingAirport = boardingAirport;
	}

	/**
	 * @return the destinationAirport
	 */
	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	/**
	 * @param destinationAirport the destinationAirport to set
	 */
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	
	
}
