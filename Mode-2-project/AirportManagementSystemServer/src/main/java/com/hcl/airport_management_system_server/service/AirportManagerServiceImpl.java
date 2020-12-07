package com.hcl.airport_management_system_server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport_management_system_server.dao.AirportManagerDao;
import com.hcl.airport_management_system_server.model.Manager;

@Service
public class AirportManagerServiceImpl implements AirportManagerService {
	@Autowired
	AirportManagerDao airportManagerDao;

	@Override
	public Manager addManagerService(Manager manager) {
		Manager manager2 = airportManagerDao.save(manager);
		return manager2;
	}

	@Override
	public Iterable<Manager> findAll() {
		List<Manager> managers = new ArrayList<Manager>();
		airportManagerDao.findAll().forEach(managers::add);
		return managers;
	}

	@Override
	public Manager findByManagerEmail(String ManagerEmail) {
		Manager Manager = airportManagerDao.findByManagerEmail(ManagerEmail);
		return Manager;
	}

	@Override
	public Manager updateManagerStatus(Manager manager) {

		Manager manager1 = airportManagerDao.save(manager);
		return manager1;
	}
}
