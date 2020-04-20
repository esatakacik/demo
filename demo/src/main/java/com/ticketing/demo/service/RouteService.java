package com.ticketing.demo.service;

import java.util.List;

import com.ticketing.demo.model.Route;

public interface RouteService {

	Route saveRoute(Route route);
	
	Route findById(Long id);
	
	Route findByBoardingAirport_IdAndDestinationAirport_Id(Long boardingAirport_Id, Long destinationAirport_Id);

	List<Route> findByAirportName(String name);

	List<Route> findByBoardingAirportName(String name);

	List<Route> findByDestinationAirportName(String name);
}
