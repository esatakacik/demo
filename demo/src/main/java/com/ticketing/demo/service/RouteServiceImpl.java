package com.ticketing.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketing.demo.model.Route;
import com.ticketing.demo.repository.RouteRepository;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

	@Autowired
	RouteRepository routeRepository;

	@Override
	public Route saveRoute(Route route) {
		return routeRepository.save(route);
	}

	@Override
	public Route findByBoardingAirport_IdAndDestinationAirport_Id(Long boardingAirport_Id, Long destinationAirport_Id) {
		return routeRepository.findByBoardingAirport_IdAndDestinationAirport_Id(boardingAirport_Id, destinationAirport_Id).orElse(null);
	}
	
	@Override
	public List<Route> findByBoardingAirportName(String name){
		return routeRepository.findByBoardingAirport_Name(name).orElse(null);
	}
	
	@Override
	public List<Route> findByDestinationAirportName(String name){
		return routeRepository.findByDestinationAirport_Name(name).orElse(null);
	}
	
	@Override
	public List<Route> findByAirportName(String name){
		return routeRepository.findByBoardingAirport_NameOrDestinationAirport_Name(name, name).orElse(null);
	}

	@Override
	public Route findById(Long id) {
		return routeRepository.findById(id).orElse(null);
	}
}
