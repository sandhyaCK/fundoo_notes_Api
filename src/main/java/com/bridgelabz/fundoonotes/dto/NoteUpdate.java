package com.bridgelabz.fundoonotes.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class NoteUpdate {
	@NotBlank
	private Long id;
	@NotNull
	private String title;
	@NotNull
	private String description;
	private int isArchieved;
	private int isPinned;
	private int isTrashed;
	private LocalDateTime createdDateAndTime;
	private LocalDateTime upDateAndTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int isArchieved() {
		return isArchieved;
	}

	public void setArchieved(int isArchieved) {
		this.isArchieved = isArchieved;
	}

	public int isPinned() {
		return isPinned;
	}

	public void setPinned(int isPinned) {
		this.isPinned = isPinned;
	}

	public int isTrashed() {
		return isTrashed;
	}

	public void setTrashed(int isTrashed) {
		this.isTrashed = isTrashed;
	}

	public LocalDateTime getCreatedDateAndTime() {
		return createdDateAndTime;
	}

	public void setCreatedDateAndTime(LocalDateTime createdDateAndTime) {
		this.createdDateAndTime = createdDateAndTime;
	}

	public LocalDateTime getUpDateAndTime() {
		return upDateAndTime;
	}

	public void setUpDateAndTime(LocalDateTime upDateAndTime) {
		this.upDateAndTime = upDateAndTime;
	}
}
