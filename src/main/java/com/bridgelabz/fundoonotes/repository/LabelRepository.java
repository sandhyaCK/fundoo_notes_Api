package com.bridgelabz.fundoonotes.repository;

/*
 *  author : Sandhya
 */

import java.util.List;

import com.bridgelabz.fundoonotes.dto.LoginInfo;
import com.bridgelabz.fundoonotes.model.LabelData;
import com.bridgelabz.fundoonotes.model.NoteData;

public interface LabelRepository {
public LabelData save(LabelData labelData);
public LabelData getLabel(Long labelId);
public List<LabelData> getAllLabels(Long id);
public LabelData getLabel(Long userId,String name);
public int deleteLabel(Long id);
List<NoteData> getAllNotes(Long Labelid);

}
