package com.hackathon.bankapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackathon.bankapplication.model.Bank;

public interface BankDao extends CrudRepository<Bank, Integer> {
  
	public Bank findByIbanCode(String ibanCode);
	
}
