package com.bridgelabz.fundoonotes.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LabelUpdate {
Long labelId;
String name;
public Long getLabelId() {
	return labelId;
}
public void setLabelId(Long labelId) {
	this.labelId = labelId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
