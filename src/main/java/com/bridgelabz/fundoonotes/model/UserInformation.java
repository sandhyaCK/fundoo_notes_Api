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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "UserData")
public class UserInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userId;
	@Column
	private String Name;
	@Column
	private String Email;
	@Column
	private String Password;
	@Column
	private String MobileNumber;
	@Column
	private Boolean IsVerified;
	@Column
	private LocalDateTime dateTime;

	@OneToMany(cascade = CascadeType.ALL)
	
	@JoinColumn(name = "userId")
	
	//private List<NoteData> note;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		userId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public Boolean getIsVerified() {
		return IsVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		IsVerified = isVerified;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

//	public List<NoteData> getNote() {
//		return note;
//	}
//
//	public void setNote(List<NoteData> note) {
//		this.note = note;
//	}

}
