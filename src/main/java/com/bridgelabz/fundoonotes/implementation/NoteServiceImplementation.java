package com.bridgelabz.fundoonotes.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
@Repository
public  class NoteServiceImplementation  implements {
@PersistenceContext
EntityManager entityManger;

	public NoteData save(NoteData noteInformation) {
		Session session = entityManger.unwrap(Session.class);
		session.save(noteInformation);
		return noteInformation;
		
	}
	public NoteData findById(Long id) {
		Session session = entityManger.unwrap(Session.class);
		Query q = session.createQuery("FROM NoteData where id=:id");
		q.setParameter("id", id);
		return (NoteData) q.uniqueResult();
		
	}

	
	public boolean deleteNote(Long id, Long userid) {
		Session session = entityManger.unwrap(Session.class);
		Query q = session.createQuery(" delete FROM NoteData " +"where id=:id");
		q.setParameter("id", id);
		int result = q.executeUpdate();
		if(result>=1) {
			return true;
			}
		return false;
	}


	public List<NoteData> getNotes(Long userId) {
		Session session = entityManger.unwrap(Session.class);
		Query q =  session.createQuery("from NoteData where userId='" + userId + "'"
				+ "and is_trashed=false and is_archieved=false ORDER BY id DESC");
		List<NoteData> list=q.getResultList();
		
		return list;

	}

	
	public List<NoteData> restoreNote(Long userId) {
		Session session = entityManger.unwrap(Session.class);
		Query q =  session.createQuery("from NoteData where userId='" + userId + "'"
				+ "and isTrashed = true");
		List<NoteData> list=q.getResultList();
		return list;
		
	}

	
	public List<NoteData> getArchievedNotes(Long userId) {
		Session session = entityManger.unwrap(Session.class);
	 Query q = session.createQuery("from NoteData where userId='" + userId + "'"
				+ "and isArchieved= true");
	List<NoteData> list=q.getResultList();
	return list;
	}

	
	public boolean updateColor(Long id, Long userId, String color) {
		Session session = entityManger.unwrap(Session.class);
		 Query q = session.createQuery("update NoteDate set color =:color"+"and isPinned= true");
		int res = q.executeUpdate();
		 if(res>=1) {
			 return true; 
		 }
		 return false;
	}

	
	public List<NoteData> getPinnededNotes(Long userId) {
		Session session = entityManger.unwrap(Session.class);
		 Query q = session.createQuery("from NoteData where userId='" + userId + "'"
					+ "and isPinned= true");
		List<NoteData> list=q.getResultList();
		return list;
	}

}
