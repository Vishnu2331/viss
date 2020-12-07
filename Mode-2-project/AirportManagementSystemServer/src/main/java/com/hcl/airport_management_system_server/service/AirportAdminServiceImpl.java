package com.hcl.airport_management_system_server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport_management_system_server.dao.AirportAdminDao;
import com.hcl.airport_management_system_server.model.Admin;

@Service
public class AirportAdminServiceImpl implements AirportAdminService {

	@Autowired
	AirportAdminDao airportAdminDao;

	@Override
	public Admin addAdminService(Admin admin) {
		Admin admin2 = airportAdminDao.save(admin);
		return admin2;
	}

	@Override
	public Iterable<Admin> findAll() {
		List<Admin> admins = new ArrayList<Admin>();
		airportAdminDao.findAll().forEach(admins::add);
		return admins;
	}

	@Override
	public Admin findByAdminEmail(String adminEmail) {
		Admin admin = airportAdminDao.findByAdminEmail(adminEmail);
		return admin;
	}

}
