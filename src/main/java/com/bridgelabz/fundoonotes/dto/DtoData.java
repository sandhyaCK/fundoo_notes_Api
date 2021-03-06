package com.bridgelabz.fundoonotes.dto;

/*
 *  author : Sandhya
 */

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

@Getter
@Setter
@AllArgsConstructor
/* Dto class for Registration */
public class DtoData {
	private String name;
	private String email;
	private String password;
	private String mobileNumber;

	public String getName()  {
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

}
