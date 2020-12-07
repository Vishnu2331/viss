package com.hcl.airport_management_system_server.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.airport_management_system_server.model.Admin;

public interface AirportAdminDao extends CrudRepository<Admin, Long> {

	Admin findByAdminEmail(String adminEmail);

}
