package com.bridgelabz.fundoonotes.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.LabelData;
@Repository
public class LabelRepoImplementation implements LabelRepository {
@PersistenceContext
EntityManager entityManager;
	@Override
	public LabelData save(LabelData labelData) {
		Session session = entityManager.unwrap(Session.class);
	  session.saveOrUpdate(labelData);
		return labelData;
	}

	@Override
	public LabelData getLabel(Long labelId) {
		Session session = entityManager.unwrap(Session.class);
		Query q =  session.createQuery("from LabelData where labelId=:labelId");
		q.setParameter("labelId", labelId);
		return (LabelData)q.uniqueResult();
		
	}

	@Override
	public List<LabelData> getAllLabels(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Query q =  session.createQuery("from LabelData");
	    List<LabelData> labelList = q.getResultList();
		return labelList;
	}

	@Override
	public LabelData getLabel(Long userId, String name) {
		Session session = entityManager.unwrap(Session.class);
		Query q = session.createQuery("from LabelData where userId=:userId and name=:name" );
		q.setParameter("userId", userId);
		q.setParameter("name", name);
		return (LabelData)q.uniqueResult();
		}

	@Override
	public int deleteLabel(Long i) {
		Session session = entityManager.unwrap(Session.class);
		Query q=session.createQuery("delete from LabelData where labelId=:i");
		q.setParameter("labelId", i);
		int res= q.executeUpdate();
				return res;
		
	}

}
