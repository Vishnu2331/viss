package com.hcl.airport_management_system_server.service;

import java.util.List;

import com.hcl.airport_management_system_server.model.Pilot;

public interface PilotService {

	public Pilot addPilotService(Pilot pilot);

	public List<Pilot> findAll();

	public int updatePilotId(long aeroplaneId, long pilotId);

}
