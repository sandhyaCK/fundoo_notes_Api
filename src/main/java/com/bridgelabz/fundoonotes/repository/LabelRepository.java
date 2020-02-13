package com.bridgelabz.fundoonotes.repository;

import java.util.List;

import com.bridgelabz.fundoonotes.dto.LoginInfo;
import com.bridgelabz.fundoonotes.model.LabelData;

public interface LabelRepository {
public LabelData save(LabelData labelData);
public LabelData getLabel(Long labelId);
public List<LabelData> getAllLabels();
public LabelData getLabel(Long userId,String name);
public int DeleteLabel(int i);

}
