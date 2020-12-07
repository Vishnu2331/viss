package com.hcl.airport_management_system_server.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.airport_management_system_server.model.Hanger;

public interface HangerDao extends CrudRepository<Hanger, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE hanger1000 a SET a.hanger_availability=a.hanger_availability+1 WHERE a.hanger_id =:hangerId", nativeQuery = true)
	public int updateAeroplaneId(@Param("hangerId") long hangerId);
}
