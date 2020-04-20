package com.ticketing.demo.service;

import com.ticketing.demo.model.Company;

public interface CompanyService {

	Company saveCompany(Company company);

	Company findByName(String name);
	
	Company findById(Long id);
}
