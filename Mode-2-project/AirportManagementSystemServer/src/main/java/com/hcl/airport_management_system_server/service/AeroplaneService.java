package com.hcl.airport_management_system_server.service;

import java.util.List;

import com.hcl.airport_management_system_server.model.Aeroplane;

public interface AeroplaneService {

	public Aeroplane addAeroplaneService(Aeroplane aeroplane);

	public List<Aeroplane> findAll();

	public int updateHangerId( long aeroplaneId,long hangerId);

	public int updatePilotId(long aeroplaneId, long pilotId);

	public Aeroplane updateHangerStatus(Aeroplane aeroplane);

	public int updateAeroplaneId(String statusMessage,long aeroplaneId);
	public int updateAeroplaneId1(String statusMessage,long aeroplaneId);

}
