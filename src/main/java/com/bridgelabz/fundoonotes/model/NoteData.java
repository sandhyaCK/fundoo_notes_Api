package com.bridgelabz.fundoonotes.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class NoteData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String title;

	private String description;

	private int isArchieved;

	private int isPinned;

	private int isTrashed;

	private LocalDateTime createdDateAndTime;

	private LocalDateTime upDateAndTime;

	private String colour;

	private LocalDateTime reminder;

	@ManyToMany(cascade = CascadeType.ALL)
  
	@JoinTable(name = "Label_note", joinColumns = { @JoinColumn(name = "note_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Label_id") })

	@JsonBackReference

	@JsonIgnore

	private List<LabelData> list;


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

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public LocalDateTime getReminder() {
		return reminder;
	}

	public void setReminder(LocalDateTime reminder) {
		this.reminder = reminder;
	}

	public List<LabelData> getList() {
		return list;
	}

	public void setList(List<LabelData> list) {
		this.list = list;
	}
}
