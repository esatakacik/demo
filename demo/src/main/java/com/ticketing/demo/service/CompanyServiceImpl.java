package com.ticketing.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketing.demo.model.Company;
import com.ticketing.demo.repository.CompanyRepository;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company findByName(String name) {
		return companyRepository.findByName(name).orElse(null);
	}

	@Override
	public Company findById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}
}
