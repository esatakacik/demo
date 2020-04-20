package com.ticketing.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketing.demo.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

	Optional<List<Ticket>> findByFlight_Id(Long flightId);
}
