package com.hcl.airport_management_system_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport_management_system_server.dao.PilotDao;

import com.hcl.airport_management_system_server.model.Pilot;

@Service
public class PilotServiceImpl implements PilotService {

	@Autowired
	PilotDao pilotDao;

	@Override
	public Pilot addPilotService(Pilot pilot) {
		Pilot pilot2 = pilotDao.save(pilot);
		return pilot2;
	}

	@Override
	public List<Pilot> findAll() {
		List<Pilot> pilots = (List<Pilot>) pilotDao.findAll();
		return pilots;
	}

	@Override
	public int updatePilotId(long aeroplaneId, long pilotId) {
		int a = pilotDao.updatePilotId(aeroplaneId, pilotId);
		return a;
	}
}
