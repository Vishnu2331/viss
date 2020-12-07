package com.hcl.pp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
@Repository
public interface UserDAO {
	public void addUser(User user);
	public User updateUser(User userId);
	public List<User> listAllUsers();
	public User getUserById(int userId);
	public String findUserName(int userId);
	public Pet buyPet(int userId);
	public List<Pet> getMyPets(int userId);
	public boolean authenticateUser(String userEmail,String userPassword);
	public Long getIdByUserEmail(String userEmail);
}
