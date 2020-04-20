package com.ticketing.demo.service;

import com.ticketing.demo.model.Airport;

public interface AirportService {

	Airport saveAirport(Airport airport);
	
	Airport findByName(String name);
	
	Airport findById(Long id);
}
