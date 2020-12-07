package com.hcl.airport_management_system_server.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.airport_management_system_server.model.Aeroplane;

public interface AeroplaneDao extends CrudRepository<Aeroplane, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE aeroplane1000 a SET a.hanger_id = :hangerId WHERE a.aeroplane_id =:aeroplaneId", nativeQuery = true)
	public int updateHangerId(@Param("hangerId") long hangerId, @Param("aeroplaneId") long aeroplaneId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE aeroplane1000 a SET a.pilot_pilot_id = :pilotId WHERE a.aeroplane_id =:aeroplaneId", nativeQuery = true)
	public int updatePilotId(@Param("pilotId") long pilotId, @Param("aeroplaneId") long aeroplaneId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE aeroplane1000 a SET a.aeroplane_hanger_status =:statusMessage WHERE a.aeroplane_id =:aeroplaneId", nativeQuery = true)
	public int updateAeroplaneId(@Param("statusMessage") String statusMessage, @Param("aeroplaneId") long aeroplaneId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE aeroplane1000 a SET a.aeroplane_pilot_status =:statusMessage WHERE a.aeroplane_id =:aeroplaneId", nativeQuery = true)
	public int updateAeroplaneId1(@Param("statusMessage") String statusMessage, @Param("aeroplaneId") long aeroplaneId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE aeroplane1000 a SET a.hanger_id =NULL WHERE a.aeroplane_id =:aeroplaneId", nativeQuery = true)
	public int updateHangerId1(@Param("aeroplaneId") long aeroplaneId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE aeroplane1000 a SET a.pilot_pilot_id =NULL WHERE a.aeroplane_id =:aeroplaneId", nativeQuery = true)
	public int updatePilotId1(@Param("aeroplaneId") long aeroplaneId);
}
