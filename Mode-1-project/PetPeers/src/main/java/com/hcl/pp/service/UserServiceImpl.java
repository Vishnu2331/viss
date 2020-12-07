package com.hcl.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.dao.UserDAO;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@Service
public class UserServiceImpl implements UserService {
  
	@Autowired
	private UserDAO userDAO;
    
	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	public User updateUser(User userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserName(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet buyPet(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> getMyPets(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Long getIdByUserEmail(String userEmail) {
		Long petId=userDAO.getIdByUserEmail(userEmail);
		return petId;
	}

}
