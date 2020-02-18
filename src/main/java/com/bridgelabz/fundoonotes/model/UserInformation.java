package com.bridgelabz.fundoonotes.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class UserInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String mobileNumber;
	@Column
	private int isVerified;
	@Column
	private LocalDateTime dateTime;

	@OneToMany(cascade = CascadeType.ALL)

	@JoinColumn(name = "userId")

	 private List<NoteData> note;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "collaborator_note", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "note_id") })
	@JsonIgnore
	private List<NoteData> collabrateNote;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

public List<NoteData> getNote() {
		return note;
	}

	public void setNote(List<NoteData> note) {
		this.note = note;
	}

	public List<NoteData> getCollabrateNote() {
		return collabrateNote;
	}

	public void setColabrateNote(List<NoteData> collabrateNote) {
		this.collabrateNote = collabrateNote;
	}

}
