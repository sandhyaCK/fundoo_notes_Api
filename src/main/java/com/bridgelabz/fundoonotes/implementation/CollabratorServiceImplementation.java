package com.bridgelabz.fundoonotes.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.CollabratorService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;


@Service
public class CollabratorServiceImplementation implements CollabratorService{
@Autowired
private JwtGenerator generate;
UserInformation user = new UserInformation();
@Autowired
private UserRepository repository;
@Autowired
private NoteRepository noteRepo;


@Transactional
	@Override
	public NoteData addCollabrator(Long NoteId, String token, String email) {
		
		UserInformation collabrator = repository.getUser(email);
		try {
			Long id =(Long)generate.parseJWT(token);
			user =repository.findUserById(id);
		}
		catch(Exception e) {
			throw new UserException("User doesnot exist with this id");
			}
		if(user!=null) {
			if(collabrator!=null) {
				NoteData note = noteRepo.findById(NoteId);
				collabrator.getCollabrateNote().add(note);
				return note;
				}
		
		else {
			throw new UserException("user doesnot exist to collabrate");
		}}else {
				throw new UserException("user not present");
			}
		
	}
@Transactional
	@Override
	public List<NoteData> getAllCollabrator(String token) {
		Long id = (Long)generate.parseJWT(token);
		user = repository.findUserById(id);
		List<NoteData> note = user.getCollabrateNote();
		return note;
	}
@Transactional
	@Override
	public NoteData deleteCollabrator(Long NoteId, String token, String email) {
		UserInformation collabrator = repository.getUser(email);
		try {
			Long id =(Long)generate.parseJWT(token);
			user =repository.findUserById(id);
		}
		catch(Exception e) {
			throw new UserException("User doesnot exist with this id");
			}
		if(user!=null) {
			if(collabrator!=null) {
				NoteData note = noteRepo.findById(NoteId);
				collabrator.getCollabrateNote().remove(note);
				return note;
				}
		
		else {
			throw new UserException("user doesnot exist to collabrate");
		}}else {
				throw new UserException("user not present");
			}
		
	}

}
