package com.hackathon.bankapplication.service;

import com.hackathon.bankapplication.model.Customer;

public interface CustomerService {

	
	public Long saveCustomer(Customer customer);

	public String checkLogin(Long customerId,String password);
}
