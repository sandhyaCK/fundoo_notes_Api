//package com.bridgelabz.fundoonotes.implementation;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bridgelabz.fundoonotes.dto.LabelDto;
//import com.bridgelabz.fundoonotes.dto.LabelUpdate;
//import com.bridgelabz.fundoonotes.exception.UserException;
//import com.bridgelabz.fundoonotes.model.LabelData;
//import com.bridgelabz.fundoonotes.model.NoteData;
//import com.bridgelabz.fundoonotes.model.UserInformation;
//import com.bridgelabz.fundoonotes.repository.LabelRepository;
//import com.bridgelabz.fundoonotes.repository.NoteRepository;
//import com.bridgelabz.fundoonotes.repository.UserRepository;
//import com.bridgelabz.fundoonotes.service.LabelService;
//import com.bridgelabz.fundoonotes.utility.JwtGenerator;
//
//@Service
//public class LabelServiceImplementation implements LabelService {
//	@Autowired
//	private JwtGenerator generate;
//	@Autowired
//	private UserRepository Repository;
//	@Autowired
//	private LabelRepository LabelRepo;
//	@Autowired
//	private ModelMapper modelMapper;
//	@Autowired
//	private LabelData labelData;
//	@Autowired
//	NoteRepository noteRepo;
//	@Autowired
//	UserRepository repository;
//
//	@Override
//	@Transactional
//	public void createLabel(LabelDto labelDto, String token) {
//    Long id =null;
//    try {
//id = (Long)generate.parseJWT(token);
//}catch(Exception e) {
//	throw new UserException("user doesn't exist with id");
//}
//UserInformation user = Repository.findUserById(id);
//if(user!=null) {
//	LabelData labelData = LabelRepo.getLabel(user.getUserId(), labelDto.getName());
//	if(labelData==null) {
//		labelData =modelMapper.map(labelDto, LabelData.class);
//		labelData.setUserId(user.getUserId());
//		 LabelRepo.save(labelData);
//	}	
//		 else {
//				throw new UserException("label with that name is already present ");
//			}
//		} else {
//			throw new UserException("note does not exist with userid");
//		}
//		}
//	@Transactional
//	@Override
//	public void createLabelAndMAp(LabelDto labelDto, String token) {
//		 Long id =null;
//		    try {
//		id = (Long)generate.parseJWT(token);
//		}catch(Exception e) {
//			throw new UserException("user doesn't exist with id");
//		}
//		UserInformation user = Repository.findUserById(id);
//		if(user==null) {
//		BeanUtils.copyProperties(labelDto,LabelDto.class);
//		
//		labelData.setUserId(user.getUserId());
//		LabelRepo.save(labelData);
//		NoteData note = noteRepo.findById(id);
//		note.
//		note.getList().add(labelData);
//		noteRepo.save(note);
//	}
//	else {
//		throw new UserException("label with that name is already present ");
//	}
//		
//		@Transactional
//	@Override
//	public void addLabel(Long labelId, String token, Long noteId) {
//			NoteData note = noteRepo.findById(noteId);
//			LabelData label = Labelrepo.fetchLabelById(labelId);
//			label.getList().add(note);
//			Labelrepo.save(label);
//		}
//	}
//	@Transactional
//	@Override
//	public void removeLabel(Long labelId, String token, Long noteId) {
//		NoteData note = noteRepo.findById(noteId);
//		LabelData label = Labelrepo.fetchLabelById(labelId);
//		label.getList().remove(note);
//		Labelrepo.save(label);
//	}
//
//	}
//@Transactional
//	@Override
//	public void deleteLabel(LabelUpdate label, String token) {
//		Long id = null;
//		try {
//			id = (Long)generate.parseJWT(token);
//
//		} catch (Exception e) {
//			throw new UserException("user does not exist");
//
//		}
//		UserInformation user = repository.getUserById(id);
//		if (user != null) {
//			LabelData labelInfo = Labelrepo.fetchLabelById(label.getLabelId());
//			if (labelInfo != null) {
//				
//				Labelrepo.deleteLabel(label.getLabelId());
//			} else {
//				throw new UserException("labelwith name does not exist");
//			}
//		} else {
//			throw new UserException("user does not exist");
//		}
//	}
//@Transactional
//	@Override
//	public void edit(LabelUpdate label, String token) {
//		Long id = null;
//		try {
//			id = (Long) generate.parseJWT(token);
//
//		} catch (Exception e) {
//			throw new UserException("user does not exist");
//
//		}
//		UserInformation user = repository.getUserById(id);
//		if (user != null) {
//			LabelData labelInfo = Labelrepo.fetchLabelById(label.getLabelId());
//			if (labelInfo != null) {
//				labelInfo.setName(label.getLabelName());
//				Labelrepo.save(labelInfo);
//			} else {
//				throw new UserException("labelwith name does not exist");
//			}
//		} else {
//			throw new UserException("user does not exist");
//		}
//	}
//@Transactional
//	@Override
//	public List<LabelData> getAllLabels(String token) {
//		try {
//			Long id = (Long) generate.parseJWT(token);
//			// UserInformation user = repository.findUserById(id);
//			// if(user!=null) {
//			List<LabelData> list = LabelRepo.getAllLabels(id);
//			return list;
//
//		} catch (Exception e) {
//			throw new UserException("user doesn't exist with id");
//		}
//	}
//@Transactional
//	@Override
//	public List<NoteData> getNotes(String token, Long labelId) {
//		Long id = (Long) generate.parseJWT(token);
//		LabelData label = LabelRepo.getLabel(labelId);
//	//	List<NoteData> list = label.getList();
//		return label;;
//	}
//
//	
//
//}
