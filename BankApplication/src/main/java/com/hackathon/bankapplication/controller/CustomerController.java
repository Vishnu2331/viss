package com.hackathon.bankapplication.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.bankapplication.model.Customer;
import com.hackathon.bankapplication.service.CustomerService;
import com.hackathon.bankapplication.vo.LoginVo;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
    CustomerService customerService;
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping("/signup")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer) {
		log.info("customer registration");
		try {
			
			Long id=customerService.saveCustomer(customer);
			String message="customer with "+id+" created";
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/login") 
	public ResponseEntity<String> customerLogin(@RequestBody LoginVo loginVo) {
		log.info("customer login");
		try {
			String message=customerService.checkLogin(loginVo.getCustomerId(),loginVo.getPassword());
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
