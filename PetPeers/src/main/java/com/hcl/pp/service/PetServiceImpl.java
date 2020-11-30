package com.hcl.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.dao.PetDAO;
import com.hcl.pp.model.Pet;
@Service
public class PetServiceImpl implements PetService {
    @Autowired
	private PetDAO petDAO;
	@Override
	@Transactional
	public Pet savePet(Pet pet) {
	Pet pet1=petDAO.savePet(pet);
		return pet1;
	}

	@Override
	@Transactional
	public List<Pet> getAllPets() {
		List<Pet> pets=petDAO.fetchAllPets();
		return pets;
	}

	@Override
	@Transactional
	public Pet getPetById(Long petId) {
		
		return null;
	}

	@Override
	@Transactional
	public int setOwnerId(Long petId, Long ownerId) {
		int status=petDAO.setOwnerId(petId, ownerId);
		return status;
	}

}
