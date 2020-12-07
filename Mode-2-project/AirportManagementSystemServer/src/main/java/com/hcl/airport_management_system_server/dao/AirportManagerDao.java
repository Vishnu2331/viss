package com.hcl.airport_management_system_server.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.airport_management_system_server.model.Manager;

public interface AirportManagerDao extends CrudRepository<Manager, Long> {

	public Manager findByManagerEmail(String managerEmail);

}
