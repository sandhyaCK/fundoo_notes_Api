package com.bridgelabz.fundoonotes.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.ProfilePic;

@Repository
public class ProfilePicRepository {
	@PersistenceContext
	public EntityManager entityManager;

	public ProfilePic addProfile(ProfilePic profile) {
		Session session = entityManager.unwrap(Session.class);
		session.save(profile);
		return profile;
	}

	public boolean deleteProfile(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Query q = session.createQuery("delete from ProfilePic where userId =:id");
		q.setParameter("userId", id);
		int result = q.executeUpdate();
		if (result > 0) {
			return true;
		}
		return false;
	}

	public ProfilePic updateProfile(Long id, Long userId) {
		Session session = entityManager.unwrap(Session.class);
		Query q = session.createQuery("update ProfilePic set id=:id where userId=userId");
		q.executeUpdate();
		return null;

	}

}
