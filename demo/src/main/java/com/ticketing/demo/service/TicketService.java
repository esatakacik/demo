package com.ticketing.demo.service;

import java.util.List;

import com.ticketing.demo.model.Ticket;

public interface TicketService {

	Ticket saveTicket(Ticket ticket);

	Ticket findByTicketId(Long id);

	void deleteByIdTicketId(Long id);

	Ticket findById(Long id);

	void deleteTicket(Ticket ticket);

	List<Ticket> findAllTicketsByFlightId(Long flightId);

}
