package com.hackathon.bankapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackathon.bankapplication.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long> {

}
