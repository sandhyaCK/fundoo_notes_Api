package com.bridgelabz.fundoonotes.model;

/*
 *  author : Sandhya
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
/* Entity Class for profilePic */
public class ProfilePic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String profilePicName;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserInformation userLabel;

	public ProfilePic(String fileName, UserInformation user) {
		this.profilePicName = fileName;
		this.userLabel = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfilePicName() {
		return profilePicName;
	}

	public void setProfilePicName(String profilePicName) {
		this.profilePicName = profilePicName;
	}

	public UserInformation getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(UserInformation userLabel) {
		this.userLabel = userLabel;
	}

}
