package com.bridgelabz.fundoonotes.implementation;
import java.time.LocalDateTime;
import java.util.*;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer.JwtConfigurer;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.dto.ReminderDto;
import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.NoteService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
import com.bridgelabz.fundoonotes.dto.NoteUpdate;

@Service
public class NoteServiceImplementation implements NoteService {
@Autowired
private JwtGenerator generate;
@Autowired
UserInformation userData;
@Autowired
UserRepository repository;
@Autowired
NoteData noteData;
	@Override
	public void createNote(NoteDto information, String token) {
		try {
		Long id=(Long)generate.parseJWT(token);
		userData = repository.findUserById(id);
		if(userData!=null) {
			noteData.setCreatedDateAndTime(LocalDateTime.now());
			noteData.setArchieved(false);
			noteData.setColour("white");
			noteData.setPinned(false);
			noteData.setTrashed(false);
		userData.getNote().add(noteData);		
		NoteData data = 
		}
		}
		catch(Exception e) {
			throw new UserException("User doesnot exist with this id");
		}
		
	}

	@Override
	public void updateNote (NoteUpdate information, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNote(Long id, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void archieveNote(Long id, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pinNote(Long id, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteNotePermanently(Long id, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoteData> getAllNotes(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoteData> gettrashednotes(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoteData> getarchieved(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addColour(Long noteId, String token, String colour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NoteData> getPinneded(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReminder(Long id, String token, ReminderDto reminder) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeReminder(Long noteid, String token, ReminderDto remainder) {
		// TODO Auto-generated method stub
		
	}

}
