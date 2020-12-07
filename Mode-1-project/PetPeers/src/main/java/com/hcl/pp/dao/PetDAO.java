package com.hcl.pp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.hcl.pp.model.Pet;
@Repository
public interface PetDAO {

public Pet savePet(Pet pet);
public int setOwnerId(Long petId,Long ownerId);
public List<Pet> fetchAllPets();
public Pet getPetById(Long petId);
}
