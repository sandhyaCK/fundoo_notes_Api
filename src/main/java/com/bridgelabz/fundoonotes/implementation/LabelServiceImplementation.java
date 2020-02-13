package com.bridgelabz.fundoonotes.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
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
public class LabelServiceImplementation implements LabelService{
	@Autowired 
	private JwtGenerator generate;
	@Autowired
	private UserRepository Repository;
	@Autowired
	private	LabelRepository LabelRepo; 
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private LabelData labelData;
	@Autowired
	NoteRepository noteRepo;
	@Override
	@Transactional
	public void createLabel(LabelDto labelDto, String token) {
    Long id =null;
    try {
id = (Long)generate.parseJWT(token);
}catch(Exception e) {
	throw new UserException("user doesn't exist with id");
}
UserInformation user = Repository.findUserById(id);
if(user!=null) {
	LabelData labelData = LabelRepo.getLabel(user.getUserId(), labelDto.getName());
	if(labelData==null) {
		labelData =modelMapper.map(labelDto, LabelData.class);
		labelData.setUserId(user.getUserId());
		 LabelRepo.save(labelData);
	}	
		 else {
				throw new UserException("label with that name is already present ");
			}
		} else {
			throw new UserException("note does not exist with userid");
		}

	@Override
	public void createLabelAndMAp(LabelDto labelDto, String token) {
		 Long id =null;
		    try {
		id = (Long)generate.parseJWT(token);
		}catch(Exception e) {
			throw new UserException("user doesn't exist with id");
		}
		UserInformation user = Repository.findUserById(id);
		BeanUtils.copyProperties(labelDto, LabelData.class);
		labelData.setUserId(user.getUserId());
		LabelRepo.save(labelData);
		NoteData note = noteRepo.findById(noteId);
		note.getList().add(labelData);
		noteRepo.save(note);
	} else {
		throw new UserException("label with that name is already present ");
	}
} else {
	throw new UserException("note does not exist with userid");
}
	}
	}

	@Override
	public void addLabel(Long labelId, String token, Long noteId) {
		
	}

	@Override
	public void removeLabel(Long labelId, String token, Long noteId) {
	
	}

	@Override
	public void deleteLabel(LabelUpdate label, String token) {
		
		
	}

	@Override
	public void edit(LabelUpdate label, String token) {
		
	}

	@Override
	public List<LabelData> getAllLabels(String token) {
		
		return null;
	}

	@Override
	public List<NoteData> getNotes(String token) {
		
		return null;
	}

}
