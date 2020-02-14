package com.bridgelabz.fundoonotes.dto;

import lombok.Data;

@Data
public class LoginInfo {
String Email;
String Password;

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

}
