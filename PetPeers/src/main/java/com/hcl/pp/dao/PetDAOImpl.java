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

@Repository
public class PetDAOImpl implements PetDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(PetDAOImpl.class);

	@Override
	public Pet getPetById(Long petId) {

		return null;
	}

	@Override
	public Pet savePet(Pet pet) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(pet);
		logger.info("Pet saved successfully, Pet Details=" + pet);
		return pet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pet> fetchAllPets() {
		Session session = this.sessionFactory.getCurrentSession();
		Query<Pet> createQuery = session.createQuery("from Pet");
		Query<Pet> query = createQuery;
		List<Pet> list = query.list();
		logger.info("Pets Loaded from Database Successfully");
		return list;
	}

	@Override
	public int setOwnerId(Long petId, Long ownerId) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Integer> q = session.createNativeQuery("update pets set pet_ownerid=:n where id=:i");
		q.setParameter("n", ownerId);
		q.setParameter("i", petId);

		int status = q.executeUpdate();
		logger.info("Owner id in Pets_Table Update Successfully");
		return status;
	}

}
