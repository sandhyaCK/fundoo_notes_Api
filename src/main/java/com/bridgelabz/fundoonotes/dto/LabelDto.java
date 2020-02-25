package com.bridgelabz.fundoonotes.dto;
import lombok.Getter;

import lombok.Data;
import lombok.Setter;
@Data
@Getter
@Setter
public class LabelDto {
String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
	
}
