package com.hcl.pp.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
	private SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	
	@Override
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details="+user);
	}

	@Override
	public User updateUser(User userId) {
		
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

	@SuppressWarnings("unchecked")
	@Override
	public boolean authenticateUser(String userEmail, String userPassword) {
		Session session = this.sessionFactory.getCurrentSession();
		boolean userFound = false;
		
		String SQL_QUERY =" from User as o where o.userEmail=:e and o.userPassword=:p";
		Query<Long> query = session.createQuery(SQL_QUERY);
		query.setParameter("e",userEmail);
		query.setParameter("p",userPassword);
		List<Long> list = query.list();

		if ((list != null) && (list.size() > 0)) {
			logger.info("User Authentication");
			userFound= true;
		}
		return userFound;
	}

	@Override
	public Long getIdByUserEmail(String userEmail) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Long> query=session.createQuery("select userId from User where userEmail=:e");
		query.setParameter("e", userEmail);
		List<Long> list=query.list(); 
		Long userId=0L;
		if ((list != null) && (list.size() > 0)) {
			logger.info("id retrieved Successfuuly");
			userId=list.get(0);
		}
	    
		return userId;
	}

	

}
