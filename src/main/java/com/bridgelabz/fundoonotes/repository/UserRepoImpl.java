package com.bridgelabz.fundoonotes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;



import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.dto.DtoData;
import com.bridgelabz.fundoonotes.dto.PasswordUpdate;
import com.bridgelabz.fundoonotes.model.UserInformation;
@Repository
public class UserRepoImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManger;

	@Override
	public UserInformation save(UserInformation information) {
		Session session=entityManger.unwrap(Session.class);
		 session.saveOrUpdate(information);
		return information;
	}

	@Override
	
	public UserInformation findUserById(long id) {
		Session session=entityManger.unwrap(Session.class);
		Query q = session.createQuery("FROM UserInformation where id=:id");
		q.setParameter("id",id );
		return(UserInformation) q.uniqueResult();
	}

	@Override
	public UserInformation getUser(String email) {
		Session session=entityManger.unwrap(Session.class);
		Query q = session.createQuery("FROM UserInformation where email=:email");
		q.setParameter("email", email);
		
		return (UserInformation)q.uniqueResult();
	}

	@Override
	public boolean update(PasswordUpdate information, long id) {
		Session session = entityManger.unwrap(Session.class);
		Query q =  session.createQuery("update UserInformation set password=:p" +" "+" where id=:id" );
		q.setParameter(" p",information.getConfirmPassword());
		q.setParameter("id", id);
		int status=q.executeUpdate();
		if(status>0) {
			return true;
		}else {
		return false;
	}
}
	@Override
	public boolean verify(Long id) {
		Session session = entityManger.unwrap(Session.class);
		Query q = session.createQuery("update UserInformation set is_verified =:p" + " " + " " + " where user_id=:i");
		q.setParameter("p", true);
		q.setParameter("i", id);
		int status = q.executeUpdate();
		if (status > 0) {
			return true;

		} else {
			return false;
		}

	}

	@Override
	public List<UserInformation> getUsers() {
		Session session = entityManger.unwrap(Session.class);
		List<UserInformation> userList = session.createQuery("FROM UserInformation").getResultList();
		return userList;
	}
	


}
