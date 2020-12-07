package com.hcl.airport_management_system_server.service;

import com.hcl.airport_management_system_server.model.Admin;

public interface AirportAdminService {

	public Admin addAdminService(Admin admin);

	public Iterable<Admin> findAll();

	public Admin findByAdminEmail(String adminEmail);
}
