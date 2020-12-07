package com.hcl.pp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.pp.model.Pet;
@Service
public interface PetService {
   public Pet getPetById(Long petId);
	public Pet savePet(Pet pet);
	public List<Pet> getAllPets();
	public int setOwnerId(Long petId, Long ownerId);
	}
