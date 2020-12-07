package com.hcl.airport_management_system_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport_management_system_server.dao.HangerDao;
import com.hcl.airport_management_system_server.model.Hanger;

@Service
public class HangerServiceImpl implements HangerService {
	@Autowired
	private HangerDao hangerDao;

	@Override
	public Hanger addHangerService(Hanger hanger) {

		Hanger hanger2 = hangerDao.save(hanger);
		return hanger2;
	}

	@Override
	public List<Hanger> findAll() {
		List<Hanger> hangers = (List<Hanger>) hangerDao.findAll();
		return hangers;
	}

	@Override
	public Hanger updateHangerAvailability(Hanger hanger) {
		Hanger hanger2 = hangerDao.save(hanger);
		return hanger2;
	}

}
