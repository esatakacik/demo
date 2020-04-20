package com.ticketing.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketing.demo.model.Airport;
import com.ticketing.demo.repository.AirportRepository;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepository airportRepository; 
	
	@Override
	public Airport saveAirport(Airport airport) {
		airportRepository.save(airport);
		return airport;
	}

	@Override
	public Airport findByName(String name) {
		return airportRepository.findByName(name).orElse(null);
	}

	@Override
	public Airport findById(Long id) {
		return airportRepository.findById(id).orElse(null);
	}

}
