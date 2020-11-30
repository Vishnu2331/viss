package com.hcl.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.dao.UserDAO;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Autowired
	private UserDAO userDao;
	@Override
	@Transactional
	public boolean authenticateUse(String userEmail, String userPassword) {
	
		boolean isMatch=userDao.authenticateUser(userEmail, userPassword);
		return isMatch;
	}

}
