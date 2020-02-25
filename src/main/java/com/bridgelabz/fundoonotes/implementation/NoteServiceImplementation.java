package com.bridgelabz.fundoonotes.implementation;
import java.time.LocalDateTime;
import java.util.*;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.dto.ReminderDto;
import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.model.LabelData;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.NoteService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
import com.bridgelabz.fundoonotes.dto.NoteUpdate;

@Service
public class NoteServiceImplementation implements NoteService {
@Autowired
private JwtGenerator generate;

private UserInformation userData=new UserInformation();
@Autowired
private UserRepository repository;
private NoteData noteData =new NoteData();
@Autowired
private NoteRepository noterepo;
  

@Transactional
	@Override
	public void createNote(NoteDto information, String token) {
		try {
		Long id=(Long)generate.parseJWT(token);
		userData = repository.findUserById(id);
		if(userData!=null) {
			noteData.setCreatedDateAndTime(LocalDateTime.now());
			noteData.setArchieved(0);
			noteData.setColour("white");
			noteData.setPinned(0);
			noteData.setTrashed(0);
			noteData.setReminder(null);
			noteData.setDescription(information.getDescription());
			noteData.setTitle(information.getTitle());
		noteData.setUpDateAndTime(null);
			userData.getNote().add(noteData);		
		NoteData data = noterepo.save(noteData);
		//if (data != null) {
			//final String key = userData.getEmail();
		//}
		}
		}
		catch(Exception e) {
			throw new UserException("User doesnot exist with this id");
		}
		
	}
@Transactional
	@Override
	public void updateNote (NoteUpdate information, String token) {
		try {
		Long id=(Long)generate.parseJWT(token);
		userData = repository.findUserById(id);
		NoteData noteData = noterepo.findById(information.getId());
		if(noteData!=null) {
			noteData.setId(information.getId());
			noteData.setDescription(information.getDescription());
			noteData.setTitle(information.getTitle());
			noteData.setUpDateAndTime(LocalDateTime.now());
			noteData.setArchieved(information.isArchieved());
			noteData.setPinned(information.isPinned());
			noteData.setTrashed(information.isTrashed());
		}
		}catch (Exception e) {
			throw new UserException("user is not present");
		}
		}
		
	
@Transactional
	@Override
	public void deleteNote(Long id, String token) {
	try {

		Long userid=(Long)generate.parseJWT(token);
		userData = repository.findUserById(userid);
		NoteData noteData = noterepo.findById(id);
		if(noteData!=null) {
			noteData.setTrashed(1);
			
			noterepo.save(noteData);
		}
		}
	catch(Exception e) {
			throw new UserException("user is not present");
	}
}


@Transactional
	@Override
	public void archieveNote(Long id, String token) {
		try {
	Long userid=(Long)generate.parseJWT(token);
	userData = repository.findUserById(userid);
	NoteData noteData = noterepo.findById(id);
	if(noteData!=null) {
		noteData.setPinned(0);
		noteData.setArchieved(1);
		noteData.setUpDateAndTime(LocalDateTime.now());
		noterepo.save(noteData);
	}
		}
		catch(Exception e) {
			throw new UserException("user is not present");
	}
	}


@Transactional
	@Override
	public void pinNote(Long id, String token) {
	try {
		Long userid=(Long)generate.parseJWT(token);
		userData = repository.findUserById(userid);
		NoteData noteData = noterepo.findById(id);
		if(noteData!=null) {
			noteData.setArchieved(0);
			noteData.setPinned(1);
			noteData.setUpDateAndTime(LocalDateTime.now());
			noterepo.save(noteData);
	}
	}catch(Exception e) {
		throw new UserException("user is not present");
}	
	}


@Transactional
	@Override
	public boolean deleteNotePermanently(Long id, String token) {
	try {
		Long userid=(Long)generate.parseJWT(token);
		userData = repository.findUserById(userid);
		NoteData noteData = noterepo.findById(id);
		if(noteData!=null) {
				List<LabelData> labels = noteData.getList();
				if (labels != null) {
					labels.clear();
				}
				noterepo.deleteNote(id, userid);
		}

	 else {
		throw new UserException("note is not present");
	}
} catch (Exception e) {
	throw new UserException("user is not present");
}
return false;
	}

	
	@Transactional
	@Override
	public List<NoteData> getAllNotes(String token) {
		try {
			Long userid=(Long)generate.parseJWT(token);
		 repository.findUserById(userid);
			NoteData noteData = noterepo.findById(userid);
			if(noteData!=null) {
					List<NoteData> list =noterepo.getNotes(userid);
				 return list;
	}else {
		throw new UserException("user Doesnt exist ");
	}}		catch (Exception e) {
			throw new UserException("error occured ");
	}
			
	}
	@Transactional
	@Override
	public List<NoteData> gettrashednotes(String token) {
		try {
			Long userid=(Long)generate.parseJWT(token);
			userData = repository.findUserById(userid);
			if(userData!=null) {
				List<NoteData> list =noterepo.restoreNote(userid);
				return list;
			}
			else {
				throw new UserException("user Doesnt exist ");
			}}		catch (Exception e) {
					throw new UserException("error occured ");
			}}
	@Transactional
	@Override
	public List<NoteData> getarchieved(String token) {
			try {
				Long userid=(Long)generate.parseJWT(token);
				userData = repository.findUserById(userid);
				if(userData!=null) {
					List<NoteData> list =noterepo.getArchievedNotes(userid);
					return list;
				}
				else {
					throw new UserException("user Doesnt exist ");
				}}		catch (Exception e) {
						throw new UserException("error occured ");
				}
	
	}
	@Transactional
	@Override
	public void addColour(Long noteId, String token, String colour) {
		try {
			Long userid=(Long)generate.parseJWT(token);
			userData = repository.findUserById(userid);
			NoteData noteData = noterepo.findById(noteId);
			if(noteData!=null) {
				noteData.setColour(colour);
				noterepo.save(noteData);
				}}catch(Exception e) {
				throw new UserException("user is not present");
		}	
	}
	@Transactional
	@Override
	public List<NoteData> getPinneded(String token) {
		try {
			Long userid=(Long)generate.parseJWT(token);
			userData = repository.findUserById(userid);
			if(userData!=null) {
				List<NoteData> list =noterepo.getPinnededNotes(userid);
				return list;
			}
			else {
				throw new UserException("user Doesnt exist ");
			}}		catch (Exception e) {
					throw new UserException("error occured ");
			}
	}
	@Transactional
	@Override
	public void addReminder(Long id, String token, ReminderDto reminder) {
	
		try {
			Long userid=(Long)generate.parseJWT(token);
			userData = repository.findUserById(userid);
			NoteData noteData = noterepo.findById(id);
			if(noteData!=null) {
				noteData.setReminder(reminder.getRemainder());
				noterepo.save(noteData);
				}}catch(Exception e) {
				throw new UserException("user is not present");
		}	
		
	}

	@Transactional
	@Override
	public void removeReminder(Long noteid, String token, ReminderDto remainder) {

		try {
			Long userid=(Long)generate.parseJWT(token);
			userData = repository.findUserById(userid);
			NoteData noteData = noterepo.findById(noteid);
			if(noteData!=null) {
				noteData.setReminder(null);
				noterepo.save(noteData);
				}}catch(Exception e) {
				throw new UserException("user is not present");
		}	
		
			}
	}


