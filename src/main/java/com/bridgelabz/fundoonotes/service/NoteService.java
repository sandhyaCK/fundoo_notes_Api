package com.bridgelabz.fundoonotes.service;

/*
 *  author : Sandhya
 */

import java.util.List;

import com.bridgelabz.fundoonotes.dto.LoginInfo;
import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.dto.NoteUpdate;
import com.bridgelabz.fundoonotes.dto.ReminderDto;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;

public interface NoteService {

	void createNote(NoteDto information, String token);

	void updateNote(NoteUpdate information, String token);

	void deleteNote(Long id, String token);

	void archieveNote(Long id, String token);

	void pinNote(Long id, String token);

	boolean deleteNotePermanently(Long id, String token);

	 List<NoteData> getAllNotes(String token);

	List<NoteData> gettrashednotes(String token);

	List<NoteData> getarchieved(String token);

	void addColour(Long noteId, String token, String colour);

	List<NoteData> getPinneded(String token);

	void addReminder(Long noteid, String token, ReminderDto reminder);

	void removeReminder(Long noteid, String token, ReminderDto reminder);

}
