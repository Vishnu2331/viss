package com.hcl.airport_management_system_server.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.airport_management_system_server.model.Pilot;

public interface PilotDao extends CrudRepository<Pilot, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE pilot1000 a SET a.address_aeroplane_id =:aeroplaneId WHERE a.pilot_id =:pilotId", nativeQuery = true)
	public int updatePilotId(@Param("aeroplaneId") long aeroplaneId, @Param("pilotId") long pilotId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE pilot1000 a SET a.address_aeroplane_id =NULL WHERE a.pilot_id =:pilotId", nativeQuery = true)
	public int updateAeroplaneId(@Param("pilotId") long pilotId);

}
