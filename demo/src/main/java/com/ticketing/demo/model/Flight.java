package com.ticketing.demo.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ticketing.demo.util.Util;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date")
	private LocalDateTime date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "route_id", referencedColumnName = "id")
	private Route route;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;

	@Column(name = "quota")
	private Integer quota;

	@Column(name = "initial_price")
	private Double initialPrice;

	@OneToMany(mappedBy = "flight", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Ticket> tickets;

	@Transient
	private Double dynamicPrice;

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
	 * @return the quota
	 */
	public Integer getQuota() {
		return quota;
	}

	/**
	 * @param quota the quota to set
	 */
	public void setQuota(Integer quota) {
		this.quota = quota;
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
	 * @param initialPrice the initialPrice to set
	 */
	public void setInitialPrice(Double initialPrice) {
		this.initialPrice = initialPrice;
	}

	@Transient
	public Double getDynamicPrice() {
		if (this.tickets == null) {
			return initialPrice;
		}
		dynamicPrice = 0.0;
		dynamicPrice = initialPrice + (initialPrice*Util.round(Math.round(this.tickets.size() * 100.0 ) / getQuota())/100);
		return dynamicPrice;
	}

	/**
	 * @return the initialPrice
	 */
	public Double getInitialPrice() {
		return initialPrice;
	}

	/**
	 * @param dynamicPrice the dynamicPrice to set
	 */
	@Transient
	public void setDynamicPrice(Double dynamicPrice) {
		this.dynamicPrice = dynamicPrice;
	}
	
}
