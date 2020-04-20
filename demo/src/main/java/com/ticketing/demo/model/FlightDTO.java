package com.ticketing.demo.model;

import java.time.LocalDateTime;

public class FlightDTO {

	private Long id;
	private LocalDateTime date;
	private Route route;
	private Company company;
	private Double dynamicPrice;
	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	/**
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(Route route) {
		this.route = route;
	}
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	/**
	 * @return the dynamicPrice
	 */
	public Double getDynamicPrice() {
		return dynamicPrice;
	}
	/**
	 * @param dynamicPrice the dynamicPrice to set
	 */
	public void setDynamicPrice(Double dynamicPrice) {
		this.dynamicPrice = dynamicPrice;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}
