package com.bridgelabz.fundoonotes.dto;

/*
 *  author : Sandhya
 */

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
/*Dto class for NoteData*/
public class NoteDto {
	@NotNull
	private String title;
	@NotNull
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
