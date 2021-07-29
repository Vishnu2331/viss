package com.hackathon.bankapplication.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.bankapplication.model.Customer;
import com.hackathon.bankapplication.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

	public Long saveCustomer(Customer customer) {
		log.info("registering customer-service class");

		Customer customer1 = customerDao.save(customer);
		return customer1.getCustomerId();
	}

	@Override
	public String checkLogin(Long customerId,String password) {
		log.info("validating the customer to log - service class");

	Optional<Customer> customer=customerDao.findById(customerId);
	Customer customer1=null;
	String message=null;
	if(customer.isPresent())
	{
		customer1=customer.get();
		if(customer1.getCustomerId()==customerId && customer1.getCustomerPassword().equals(password))
		{
			message="Customer Login Successfull";
		}
		else {
			message="Incorrect UserName and Password";
		}
		
	}
	else
	{
		message="customer not registered ";
	}
	return message;
	}
}

