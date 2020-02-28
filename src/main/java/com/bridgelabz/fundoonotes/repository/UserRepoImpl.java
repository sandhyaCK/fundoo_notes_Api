package com.bridgelabz.fundoonotes.repository;

/*
 *  author : Sandhya
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.bridgelabz.fundoonotes.dto.PasswordUpdate;
import com.bridgelabz.fundoonotes.model.UserInformation;

@Repository
public class UserRepoImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManger;

	/* Query for save the data into userDatabase */
	@Override
	public UserInformation save(UserInformation information) {
		Session session = entityManger.unwrap(Session.class);
		session.saveOrUpdate(information);
		return information;
	}

	/* Query to find the user by id */
	@Override
	public UserInformation findUserById(Long id) {
		Session session = entityManger.unwrap(Session.class);
		Query<UserInformation> q = session.createQuery("FROM UserInformation where id=:id");
		q.setParameter("id", id);
		return (UserInformation) q.uniqueResult();
	}

	/* Query to get the usr information bby email */
	@Override
	public UserInformation getUser(String email) {
		Session session = entityManger.unwrap(Session.class);
		Query<UserInformation> q = session.createQuery("FROM UserInformation where email=:email");
		q.setParameter("email", email);

		return (UserInformation) q.uniqueResult();
	}

	/* Query to update the PasswordInformation */
	@Override
	public boolean update(PasswordUpdate information, Long id) {
		Session session = entityManger.unwrap(Session.class);
		Query<UserInformation> q = session
				.createQuery("update UserInformation set password=:p" + " " + " where id=:id");
		q.setParameter(" p", information.getConfirmPassword());
		q.setParameter("id", id);
		int status = q.executeUpdate();
		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Query to update the verify to TRUE once the token taken from the
	 * RegisteredUser
	 */
	@Override
	public boolean verify(Long id) {
		Session session = entityManger.unwrap(Session.class);
		Query<UserInformation> q = session
				.createQuery("update UserInformation set is_verified =:p" + " " + " " + " where user_id=:i");
		q.setParameter("p", true);
		q.setParameter("i", id);
		int status = q.executeUpdate();
		if (status > 0) {
			return true;

		} else {
			return false;
		}

	}

	/* Query to list out all the User Information */
	@Override
	public List<UserInformation> getUsers() {
		Session session = entityManger.unwrap(Session.class);
		List<UserInformation> userList = session.createQuery("FROM UserInformation").getResultList();
		return userList;
	}

}
