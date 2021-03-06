package com.bridgelabz.fundoonotes.implementation;

/*
 *  author : Sandhya
 */

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.dto.LabelDto;
import com.bridgelabz.fundoonotes.dto.LabelUpdate;
import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.model.LabelData;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.LabelRepository;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.LabelService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;

@Service
public class LabelServiceImplementation implements LabelService {
	@Autowired
	private JwtGenerator generate;
	@Autowired
	private UserRepository Repository;
	@Autowired
	private LabelRepository LabelRepo;
	@Autowired
	private ModelMapper modelMapper;

	private LabelData labelData;
	@Autowired
	private NoteRepository noteRepo;
	@Autowired
	private UserRepository repository;

	/* Method for creating the label */
	@Override
	@Transactional
	public void createLabel(LabelDto labelDto, String token) {
		Long id = null;
		try {
			id = (Long) generate.parseJWT(token);
		} catch (Exception e) {
			throw new UserException("user doesn't exist with id");
		}
		UserInformation user = Repository.findUserById(id);
		if (user != null) {
			LabelData labelData = LabelRepo.getLabel(user.getUserId(), labelDto.getName());
			if (labelData == null) {
				labelData = modelMapper.map(labelDto, LabelData.class);
				labelData.setUserId(user.getUserId());
				LabelRepo.save(labelData);
			} else {
				throw new UserException("label with that name is already present ");
			}
		} else {
			throw new UserException("note does not exist with userid");
		}
	}

	/* Method for creating the label and mapped with labelEntity class */
	@Transactional
	@Override
	public void createLabelAndMAp(LabelDto labelDto, String token) {
		Long id = null;
		try {
			id = (Long) generate.parseJWT(token);
		} catch (Exception e) {
			throw new UserException("user doesn't exist with id");
		}
		UserInformation user = Repository.findUserById(id);
		if (user == null) {
			BeanUtils.copyProperties(labelDto, LabelData.class);

			labelData.setUserId(user.getUserId());
			LabelRepo.save(labelData);
			NoteData note = noteRepo.findById(id);

			note.getList().add(labelData);
			noteRepo.save(note);
		} else {
			throw new UserException("label with that name is already present ");
		}
	}

	/* Method for add the label */
	@Transactional
	@Override
	public void addLabel(Long labelId, String token, Long noteId) {
		NoteData note = noteRepo.findById(noteId);
		LabelData label = LabelRepo.getLabel(labelId);
		label.getList().add(note);
		LabelRepo.save(label);
	}

	/* Method for remove the label */
	@Transactional
	@Override
	public void removeLabel(Long labelId, String token, Long noteId) {
		NoteData note = noteRepo.findById(noteId);
		LabelData label = LabelRepo.getLabel(labelId);
		label.getList().remove(note);
		LabelRepo.save(label);
	}

	/* Method for deleting the label */
	@Transactional
	@Override
	public void deleteLabel(LabelUpdate label, String token) {
		Long id = null;
		try {
			id = (Long) generate.parseJWT(token);

		} catch (Exception e) {
			throw new UserException("user does not exist");

		}
		UserInformation user = repository.findUserById(id);
		if (user != null) {
			LabelData labelInfo = LabelRepo.getLabel(label.getLabelId());
			if (labelInfo != null) {

				LabelRepo.deleteLabel(label.getLabelId());
			} else {
				throw new UserException("labelwith name does not exist");
			}
		} else {
			throw new UserException("user does not exist");
		}
	}

	/* Method for edit the label */
	@Transactional
	@Override
	public void edit(LabelUpdate label, String token) {
		Long id = null;
		try {
			id = (Long) generate.parseJWT(token);

		} catch (Exception e) {
			throw new UserException("user does not exist");

		}
		UserInformation user = repository.findUserById(id);
		if (user != null) {
			LabelData labelInfo = LabelRepo.getLabel(label.getLabelId());
			if (labelInfo != null) {
				labelInfo.setName(label.getName());
				LabelRepo.save(labelInfo);
			} else {
				throw new UserException("labelwith name does not exist");
			}
		} else {
			throw new UserException("user does not exist");
		}
	}

	/* Method for list out all the label */
	@Transactional
	@Override
	public List<LabelData> getAllLabels(String token) {
		try {
			Long id = (Long) generate.parseJWT(token);
			// UserInformation user = repository.findUserById(id);
			// if(user!=null) {
			List<LabelData> list = LabelRepo.getAllLabels(id);
			return list;

		} catch (Exception e) {
			throw new UserException("user doesn't exist with id");
		}
	}

	/* Method for list out all the label which having notes */
	@Transactional
	@Override
	public List<NoteData> getNotes(String token, Long labelId) {
		Long id = (Long) generate.parseJWT(token);
		UserInformation user=repository.findUserById(id);
		if(user!=null) {
		LabelData label = LabelRepo.getLabel(labelId);
		if(label!=null) {
		List<NoteData> note = LabelRepo.getAllNotes(labelId);
		// List<NoteData> list = label.getList();
		return (List<NoteData>) note;
		}
		}
		return null;
	}

	/* Method for get the single label of single user */
	@Transactional
	@Override
	public LabelData getSingleLabel(String token, Long LabelId) {
		Long id = null;
		try {
			id = (Long) generate.parseJWT(token);
			UserInformation user = repository.findUserById(id);
			if (user != null) {
				LabelData data = LabelRepo.getLabel(LabelId);

				return data;
			}
		} catch (Exception e) {
			throw new UserException("user does not exist");

		}
		return null;

	}
}
