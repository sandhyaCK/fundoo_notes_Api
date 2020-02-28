package com.bridgelabz.fundoonotes.service;

/*
 *  author : Sandhya
 */

import java.util.List;

import com.bridgelabz.fundoonotes.dto.LabelDto;
import com.bridgelabz.fundoonotes.dto.LabelUpdate;
import com.bridgelabz.fundoonotes.model.LabelData;
import com.bridgelabz.fundoonotes.model.NoteData;

public interface LabelService {
	
 public void createLabel(LabelDto labelDto, String token);
 public void createLabelAndMAp(LabelDto labelDto,String token);
 public  void addLabel(Long labelId,String token,Long noteId);
 public void removeLabel(Long labelId,String token,Long noteId);
 public void deleteLabel(LabelUpdate label,String token);
 public void edit(LabelUpdate label,String token);
 public List<LabelData> getAllLabels(String token);
 public List<NoteData>  getNotes(String token,Long labelId);
public LabelData getSingleLabel(String token,Long LabelId);


}
