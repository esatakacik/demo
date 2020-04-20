package com.ticketing.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketing.demo.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

	Optional<Airport> findByName(String name);
}
