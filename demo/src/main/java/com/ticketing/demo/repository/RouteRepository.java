package com.ticketing.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketing.demo.model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
	
	Optional<List<Route>> findByBoardingAirport_Name(String boardingAirportName);
	
	Optional<List<Route>> findByDestinationAirport_Name(String destinationAirportName);

	Optional<List<Route>> findByBoardingAirport_NameOrDestinationAirport_Name(String boardingAirportName, String destinationAirportName);
	
	Optional<Route> findByBoardingAirport_IdAndDestinationAirport_Id(Long boardingAirport_Id, Long destinationAirport_Id);
}
