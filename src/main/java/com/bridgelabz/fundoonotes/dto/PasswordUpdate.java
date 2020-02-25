package com.bridgelabz.fundoonotes.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PasswordUpdate {
String Email;
String NewPassword;
String  ConfirmPassword;
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getNewPassword() {
	return NewPassword;
}
public void setNewPassword(String newPassword) {
	NewPassword = newPassword;
}
public String getConfirmPassword() {
	return ConfirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	ConfirmPassword = confirmPassword;
}


}
