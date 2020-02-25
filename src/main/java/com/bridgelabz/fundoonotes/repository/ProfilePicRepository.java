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

	public ProfilePic findUserById(Long userId) {
		Session session = entityManager.unwrap(Session.class);
		Query q = session.createQuery("from UserInformation where userId=:userId");
		ProfilePic user = (ProfilePic) q.getSingleResult();
		return user;
	}

	public ProfilePic delete(ProfilePic profile) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(profile);
		return null;
	}

}
