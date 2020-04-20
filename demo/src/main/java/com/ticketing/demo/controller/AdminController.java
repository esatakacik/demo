package com.ticketing.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketing.demo.model.Airport;
import com.ticketing.demo.model.Company;
import com.ticketing.demo.model.Flight;
import com.ticketing.demo.model.Route;
import com.ticketing.demo.service.AirportService;
import com.ticketing.demo.service.CompanyService;
import com.ticketing.demo.service.FlightService;
import com.ticketing.demo.service.RouteService;

@RestController
public class AdminController {

	@Autowired
	private AirportService airportService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private FlightService flightService;

	@Autowired
	private RouteService routeService;

	@PostMapping("/api/admin/airport-create")
	public ResponseEntity<?> createAirport(@RequestBody Airport airport) {
		Airport existAirport = airportService.findByName(airport.getName());
		if (existAirport != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(airportService.saveAirport(airport), HttpStatus.CREATED);
	}

	@PostMapping("/api/admin/company-create")
	public ResponseEntity<?> createCompany(@RequestBody Company company) {
		Company existCompany = companyService.findByName(company.getName());
		if (existCompany != null) {
			return new ResponseEntity<>("Company exist", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.CREATED);
	}

	@PostMapping("/api/admin/flight-create")
	public ResponseEntity<?> createFlight(@RequestBody Flight flight) {
		Company company = companyService.findById(flight.getCompany().getId());
		if (company == null) {
			return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
		}
		flight.setCompany(company);
		Route route = routeService.findById(flight.getRoute().getId());
		if (route == null) {
			return new ResponseEntity<>("Route not found", HttpStatus.NOT_FOUND);
		}
		flight.setRoute(route);
		Flight existFlight = flightService
				.findByDateAndCompany_IdAndRoute_BoardingAirport_IdAndRoute_DestinationAirport_Id(flight.getDate(),
						company.getId(), route.getBoardingAirport().getId(), route.getDestinationAirport().getId());
		
		if (existFlight != null) {
			return new ResponseEntity<>("Flight exist", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(flightService.saveFlight(flight), HttpStatus.CREATED);
	}

	@PostMapping("/api/admin/route-create")
	public ResponseEntity<?> createRoute(@RequestBody Route route) {
		Airport boardingAirport = airportService.findById(route.getBoardingAirport().getId());
		if (boardingAirport == null) {
			return new ResponseEntity<>("boardingAirport not found", HttpStatus.NOT_FOUND);
		}
		route.setBoardingAirport(boardingAirport);
		Airport destinationAirport = airportService.findById(route.getDestinationAirport().getId());
		if (destinationAirport == null) {
			return new ResponseEntity<>("destinationAirport not found", HttpStatus.NOT_FOUND);
		}
		route.setDestinationAirport(destinationAirport);
		Route existRoute = routeService.findByBoardingAirport_IdAndDestinationAirport_Id(boardingAirport.getId(),
				destinationAirport.getId());
		if (existRoute != null) {
			return new ResponseEntity<>("Route Exist", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(routeService.saveRoute(route), HttpStatus.CREATED);
	}
}
