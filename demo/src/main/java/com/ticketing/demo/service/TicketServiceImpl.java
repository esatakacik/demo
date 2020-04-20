package com.ticketing.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketing.demo.model.Ticket;
import com.ticketing.demo.repository.FlightRepository;
import com.ticketing.demo.repository.TicketRepository;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	FlightRepository flightRepository;

	@Override
	public Ticket saveTicket(Ticket ticket) {
		List<Ticket> ticketList = findAllTicketsByFlightId(ticket.getFlight().getId());
		if (ticketList != null &&ticket.getFlight().getQuota() <= ticketList.size()) {
			throw new UnsupportedOperationException("Tickets sold out");
		}
		
		if (ticket.getFlight().getDate().isBefore(LocalDateTime.now())) {
			throw new UnsupportedOperationException("Ticket sale is over");
		}
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		ticketRepository.delete(ticket);
	}

	@Override
	public Ticket findByTicketId(Long id) {
		return ticketRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteByIdTicketId(Long id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public Ticket findById(Long id) {
		return ticketRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Ticket> findAllTicketsByFlightId(Long flightId) {
		return ticketRepository.findByFlight_Id(flightId).orElse(null);
	}
}
