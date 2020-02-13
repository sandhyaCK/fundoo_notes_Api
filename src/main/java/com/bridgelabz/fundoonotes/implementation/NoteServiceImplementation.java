package com.bridgelabz.fundoonotes.implementation;
import java.util.*;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.dto.ReminderDto;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.service.NoteService;
import com.bridgelabz.fundoonotes.dto.NoteUpdate;
import com.bridgelabz.fundoonotes.dto.ReminderDto;

public class NoteServiceImplementation implements NoteService {

	@Override
	public void createNote(NoteDto information, String token) {
		// TODO Auto-generated method stub
		
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
