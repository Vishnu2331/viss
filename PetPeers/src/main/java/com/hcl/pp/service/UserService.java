package com.hcl.pp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
@Service
public interface UserService {
public void addUser(User user);
public User updateUser(User userId);
public List<User> listAllUsers();
public User getUserById(int userId);
public String findUserName(int userId);
public Pet buyPet(int userId);
public List<Pet> getMyPets(int userId);
public Long getIdByUserEmail(String userEmail);
}
