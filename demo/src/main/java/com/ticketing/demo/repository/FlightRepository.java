package com.ticketing.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketing.demo.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	Optional<List<Flight>> findByDate(LocalDateTime date);

	Optional<List<Flight>> findByDateAndRoute_BoardingAirport_NameAndRoute_DestinationAirport_Name(LocalDateTime date,
			String boardingAirportName, String destinationAirportName);

	Optional<List<Flight>> findByRoute_BoardingAirport_Name(String name);

	Optional<List<Flight>> findByRoute_DestinationAirport_Name(String name);

	Optional<List<Flight>> findByRoute_BoardingAirport_NameOrRoute_DestinationAirport_Name(String boardingAirportName,
			String destinationAirportName);

	Optional<List<Flight>> findByCompany_Name(String name);

	Optional<List<Flight>> findByCompany_NameAndDate(String name, LocalDateTime date);

	Optional<Flight> findByDateAndCompany_IdAndRoute_BoardingAirport_IdAndRoute_DestinationAirport_Id(
			LocalDateTime date, Long companyId, Long boardingAirportId, Long destinationAirportID);

}
