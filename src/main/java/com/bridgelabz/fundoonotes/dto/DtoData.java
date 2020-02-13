package com.bridgelabz.fundoonotes.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class DtoData {
	
	
	String Name;
	String Emaill;
	String Password;
	Long MobileNumber;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmaill() {
		return Emaill;
	}
	public void setEmaill(String emaill) {
		Emaill = emaill;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		MobileNumber = mobileNumber;
	}

	}
	
