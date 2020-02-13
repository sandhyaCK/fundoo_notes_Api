package com.bridgelabz.fundoonotes.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.repository.NoteRepository;

public class NoteImplementation  implements NoteRepository{
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

	
	public List<NoteData> getTrashedNotes(Long userid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<NoteData> getArchievedNotes(Long userid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean updateColor(Long id, Long userid, String color) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<NoteData> getPinnededNotes(Long userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
