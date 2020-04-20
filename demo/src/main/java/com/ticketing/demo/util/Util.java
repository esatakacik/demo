package com.ticketing.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.ticketing.demo.model.Flight;
import com.ticketing.demo.model.FlightDTO;
import com.ticketing.demo.model.Ticket;
import com.ticketing.demo.model.TicketDTO;

public class Util {

	public static int round(long l) {
		int a = (int) ((l / 10) * 10);		
		return a;
	}
	
	public static List<FlightDTO> mapFlightList(List<Flight> flightList){
		List<FlightDTO> dtoList = new ArrayList<FlightDTO>();
		for (Flight f : flightList) {
			dtoList.add(mapFlight(f));
		}
		return dtoList;
	}
	
	public static FlightDTO mapFlight(Flight flight){
		FlightDTO dto = new FlightDTO();
		dto.setId(flight.getId());
		dto.setCompany(flight.getCompany());
		dto.setDate(flight.getDate());
		dto.setDynamicPrice(flight.getDynamicPrice());
		dto.setRoute(flight.getRoute());
		return dto;
	}
	
	public static TicketDTO mapTicket(Ticket ticket){
		TicketDTO dto = new TicketDTO();
		dto.setId(ticket.getId());
		dto.setFlight(mapFlight(ticket.getFlight()));
		dto.setPassangerName(ticket.getPassangerName());
		dto.setPrice(ticket.getPrice());
		return dto;
	}
}
