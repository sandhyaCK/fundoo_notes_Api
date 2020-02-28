package com.bridgelabz.fundoonotes.dto;

/*
 *  author : Sandhya
 */

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
/*Dto class for Login*/
public class LoginInfo {
String email;
String password;
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

}
