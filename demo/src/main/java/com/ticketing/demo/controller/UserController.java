package com.ticketing.demo.controller;

import java.util.List;

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
import com.ticketing.demo.model.Ticket;
import com.ticketing.demo.request.RequestDate;
import com.ticketing.demo.request.RequestFindAirport;
import com.ticketing.demo.request.RequestName;
import com.ticketing.demo.request.RequestNameAndDate;
import com.ticketing.demo.service.AirportService;
import com.ticketing.demo.service.CompanyService;
import com.ticketing.demo.service.FlightService;
import com.ticketing.demo.service.RouteService;
import com.ticketing.demo.service.TicketService;
import com.ticketing.demo.util.Util;

@RestController
public class UserController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private AirportService airportService;

	@Autowired
	private RouteService routeService;

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private TicketService ticketService;

	@PostMapping("/api/user/find-company")
	public ResponseEntity<?> findCompanyByName(@RequestBody RequestName request) {
		Company company = companyService.findByName(request.getName());
		if (company != null) {
			return new ResponseEntity<>(company, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("company not found", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/api/user/find-airport")
	public ResponseEntity<?> findAirportByName(@RequestBody RequestName request) {
		Airport airport = airportService.findByName(request.getName());
		if (airport != null) {
			return new ResponseEntity<>(airport, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("airport not found", HttpStatus.FOUND);
		}
	}

	@PostMapping("/api/user/find-route-by-airport-name")
	public ResponseEntity<?> findRouteByName(@RequestBody RequestName request) {
		List<Route> routeList = routeService.findByAirportName(request.getName());
		if (routeList != null && !routeList.isEmpty()) {
			return new ResponseEntity<>(routeList, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("routeList not found", HttpStatus.FOUND);
		}
	}

	@PostMapping("/api/user/find-route-by-boarding-airport-name")
	public ResponseEntity<?> findRouteByBoardingAirportName(@RequestBody RequestName request) {
		List<Route> routeList = routeService.findByBoardingAirportName(request.getName());
		if (routeList != null && !routeList.isEmpty()) {
			return new ResponseEntity<>(routeList, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("routeList not found", HttpStatus.FOUND);
		}
	}

	@PostMapping("/api/user/find-route-by-destination-airport-name")
	public ResponseEntity<?> findRouteByDestinationAirportName(@RequestBody RequestName request) {
		List<Route> routeList = routeService.findByDestinationAirportName(request.getName());
		if (routeList != null && !routeList.isEmpty()) {
			return new ResponseEntity<>(routeList, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("routeList not found", HttpStatus.FOUND);
		}
	}

	@PostMapping("/api/user/find-flight-by-date")
	public ResponseEntity<?> findFlightByDate(@RequestBody RequestDate request) {
		List<Flight> flightList = flightService.findByDate(request.getDate());
		if (flightList != null && !flightList.isEmpty()) {
			return new ResponseEntity<>(Util.mapFlightList(flightList), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("flightList not found", HttpStatus.FOUND);
		}
	}

	@PostMapping("/api/user/find-flight-by-company-name")
	public ResponseEntity<?> findFlightByCompanyName(@RequestBody RequestName request) {
		List<Flight> flightList = flightService.findByCompany_Name(request.getName());
		if (flightList != null && !flightList.isEmpty()) {
			return new ResponseEntity<>(Util.mapFlightList(flightList), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("flightList not found", HttpStatus.FOUND);
		}
	}

	@PostMapping("/api/user/find-flight-by-company-name-and-date")
	public ResponseEntity<?> findFlightByCompanyNameAndDate(@RequestBody RequestNameAndDate request) {
		List<Flight> flightList = flightService.findByCompany_NameAndDate(request.getName(), request.getDate());
		if (flightList != null && !flightList.isEmpty()) {
			return new ResponseEntity<>(Util.mapFlightList(flightList), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("flightList not found", HttpStatus.FOUND);
		}
	}

	@PostMapping("/api/user/find-flight-by-airport-name")
	public ResponseEntity<?> findFlightByAirportName(@RequestBody RequestName request) {
		List<Flight> flightList = flightService
				.findByRoute_BoardingAirport_NameOrRoute_DestinationAirport_Name(request.getName(), request.getName());
		if (flightList != null && !flightList.isEmpty()) {
			return new ResponseEntity<>(Util.mapFlightList(flightList), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("flightList not found", HttpStatus.FOUND);
		}
	}

	@PostMapping("/api/user/find-flight-by-date-and-airports")
	public ResponseEntity<?> findFlightByAirportName(@RequestBody RequestFindAirport request) {
		List<Flight> flightList = flightService.findByDateAndRoute_BoardingAirport_NameAndRoute_DestinationAirport_Name(
				request.getDate(), request.getBoardingAirportName(), request.getDestinationAirportName());
		if (flightList != null) {
			return new ResponseEntity<>(Util.mapFlightList(flightList), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("flightList not found", HttpStatus.FOUND);
		}
	}
	
	@PostMapping("/api/user/ticket-create")
	public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) {
		Flight flight = flightService.findById(ticket.getFlight().getId());
		if (flight == null) {
			return new ResponseEntity<>("flight not found", HttpStatus.NOT_FOUND);
		}
		ticket.setFlight(flight);
		ticket.setPrice(flight.getDynamicPrice());
		return new ResponseEntity<>(Util.mapTicket(ticketService.saveTicket(ticket)), HttpStatus.CREATED);
	}
	
	@PostMapping("/api/user/ticket-delete")
	public ResponseEntity<?> deleteTicket(@RequestBody Ticket ticket) {
		Ticket existTicket = ticketService.findById(ticket.getId());
		if (existTicket == null) {
			return new ResponseEntity<>("ticket not found", HttpStatus.NOT_FOUND);
		}
		ticketService.deleteTicket(ticket);
		return new ResponseEntity<>("Ticket deleted", HttpStatus.OK);
	}
	
	@PostMapping("/api/user/ticket-find")
	public ResponseEntity<?> findTicketById(@RequestBody Ticket ticket) {
		Ticket existTicket = ticketService.findById(ticket.getId());
		if (existTicket == null) {
			return new ResponseEntity<>("ticket not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(existTicket, HttpStatus.FOUND);
	}
}
