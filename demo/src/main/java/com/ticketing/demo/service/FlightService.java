package com.ticketing.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ticketing.demo.model.Flight;

public interface FlightService {

	Flight saveFlight(Flight flight);
	
	Flight findByDateAndCompany_IdAndRoute_BoardingAirport_IdAndRoute_DestinationAirport_Id(
			LocalDateTime date, Long companyId, Long boardingAirportId, Long destinationAirportID);

	List<Flight> findByDate(LocalDateTime date);

	List<Flight> findByRoute_BoardingAirport_Name(String name);

	List<Flight> findByRoute_DestinationAirport_Name(String name);

	List<Flight> findByCompany_Name(String name);

	List<Flight> findByCompany_NameAndDate(String name, LocalDateTime date);

	List<Flight> findByRoute_BoardingAirport_NameOrRoute_DestinationAirport_Name(String boardingAirportName,
			String destinationAirportName);

	List<Flight> findByDateAndRoute_BoardingAirport_NameAndRoute_DestinationAirport_Name(LocalDateTime date,
			String boardingAirportName, String destinationAirportName);
	
	Flight findById(Long id);
}
