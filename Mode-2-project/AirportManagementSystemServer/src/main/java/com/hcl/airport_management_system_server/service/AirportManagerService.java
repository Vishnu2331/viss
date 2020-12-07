package com.hcl.airport_management_system_server.service;

import com.hcl.airport_management_system_server.model.Manager;

public interface AirportManagerService {

	public Manager addManagerService(Manager manager);

	public Iterable<Manager> findAll();

	public Manager findByManagerEmail(String ManagerEmail);

	public Manager updateManagerStatus(Manager manager);

}
