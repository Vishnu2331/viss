package com.hcl.airport_management_system_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.airport_management_system_server.dao.AeroplaneDao;
import com.hcl.airport_management_system_server.dao.HangerDao;
import com.hcl.airport_management_system_server.dao.PilotDao;
import com.hcl.airport_management_system_server.model.Aeroplane;

@Service
public class AeroplaneServiceImpl implements AeroplaneService {

	@Autowired
	AeroplaneDao aeroplaneDao;

	@Autowired
	HangerDao hangerDao;

	@Autowired
	PilotDao pilotDao;

	@Override
	public Aeroplane addAeroplaneService(Aeroplane aeroplane) {

		Aeroplane aeroplane2 = aeroplaneDao.save(aeroplane);
		return aeroplane2;
	}

	@Override
	public List<Aeroplane> findAll() {
		List<Aeroplane> aeroplanes = (List<Aeroplane>) aeroplaneDao.findAll();
		return aeroplanes;
	}

	@Override
	public int updateHangerId(long aeroplaneId, long hangerId) {
		int a = aeroplaneDao.updateHangerId(hangerId, aeroplaneId);
		return a;
	}

	@Override
	public int updatePilotId(long aeroplaneId, long pilotId) {
		int a = aeroplaneDao.updatePilotId(pilotId, aeroplaneId);
		return a;
	}

	@Override
	public Aeroplane updateHangerStatus(Aeroplane aeroplane) {
		Aeroplane aeroplane2 = aeroplaneDao.save(aeroplane);
		return aeroplane2;
	}

	@Override
	public int updateAeroplaneId(String statusMessage, long aeroplaneId) {

		Aeroplane aeroplane1 = null;

		Optional<Aeroplane> aeroplane = aeroplaneDao.findById(aeroplaneId);
		if (aeroplane.isPresent()) {
			aeroplane1 = aeroplane.get();
		}
		Long hangerId = aeroplane1.getHanger().getHangerId();
		if (statusMessage.equalsIgnoreCase("REJECTED")) {
			hangerDao.updateAeroplaneId(hangerId);
			aeroplaneDao.updateHangerId1(aeroplaneId);
			statusMessage = "pending";
		}
		int a = aeroplaneDao.updateAeroplaneId(statusMessage, aeroplaneId);
		return a;
	}

	@Override
	public int updateAeroplaneId1(String statusMessage, long aeroplaneId) {

		Aeroplane aeroplane1 = null;

		Optional<Aeroplane> aeroplane = aeroplaneDao.findById(aeroplaneId);
		if (aeroplane.isPresent()) {
			aeroplane1 = aeroplane.get();
		}
		Long pilotId = aeroplane1.getPilot().getPilotId();
		if (statusMessage.equalsIgnoreCase("REJECTED")) {
			pilotDao.updateAeroplaneId(pilotId);
			aeroplaneDao.updatePilotId1(aeroplaneId);
			statusMessage = "pending";
		}
		int a = aeroplaneDao.updateAeroplaneId1(statusMessage, aeroplaneId);
		return a;

	}

}
