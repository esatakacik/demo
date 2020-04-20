package com.ticketing.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketing.demo.model.Flight;
import com.ticketing.demo.repository.FlightRepository;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Override
	public Flight saveFlight(Flight flight) {
		if (flight.getDate().isBefore(LocalDateTime.now())) {
			throw new UnsupportedOperationException("date cannot be in past time");
		}
		return flightRepository.save(flight);
	}

	@Override
	public Flight findByDateAndCompany_IdAndRoute_BoardingAirport_IdAndRoute_DestinationAirport_Id(LocalDateTime date,
			Long companyId, Long boardingAirportId, Long destinationAirportID) {
		return flightRepository.findByDateAndCompany_IdAndRoute_BoardingAirport_IdAndRoute_DestinationAirport_Id(date,
				companyId, boardingAirportId, destinationAirportID).orElse(null);
	}

	@Override
	public List<Flight> findByDate(LocalDateTime date) {
		return flightRepository.findByDate(date).orElse(null);
	}

	@Override
	public List<Flight> findByRoute_BoardingAirport_Name(String name) {
		return flightRepository.findByRoute_BoardingAirport_Name(name).orElse(null);
	}

	@Override
	public List<Flight> findByRoute_DestinationAirport_Name(String name) {
		return flightRepository.findByRoute_DestinationAirport_Name(name).orElse(null);
	}

	@Override
	public List<Flight> findByCompany_Name(String name) {
		return flightRepository.findByCompany_Name(name).orElse(null);
	}

	@Override
	public List<Flight> findByCompany_NameAndDate(String name, LocalDateTime date) {
		return flightRepository.findByCompany_NameAndDate(name, date).orElse(null);
	}

	@Override
	public List<Flight> findByRoute_BoardingAirport_NameOrRoute_DestinationAirport_Name(String boardingAirportName,
			String destinationAirportName) {
		return flightRepository.findByRoute_BoardingAirport_NameOrRoute_DestinationAirport_Name(boardingAirportName,
				destinationAirportName).orElse(null);
	}

	@Override
	public List<Flight> findByDateAndRoute_BoardingAirport_NameAndRoute_DestinationAirport_Name(LocalDateTime date,
			String boardingAirportName, String destinationAirportName) {
		return flightRepository.findByDateAndRoute_BoardingAirport_NameAndRoute_DestinationAirport_Name(date,
				boardingAirportName, destinationAirportName).orElse(null);
	}

	@Override
	public Flight findById(Long id) {
		return flightRepository.findById(id).orElse(null);
	}
}
