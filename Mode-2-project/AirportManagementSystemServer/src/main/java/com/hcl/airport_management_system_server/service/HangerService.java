package com.hcl.airport_management_system_server.service;

import java.util.List;

import com.hcl.airport_management_system_server.model.Hanger;

public interface HangerService {

	public Hanger addHangerService(Hanger hanger);

	public List<Hanger> findAll();

	public Hanger updateHangerAvailability(Hanger hanger);

}
