package com.bridgelabz.fundoonotes.service;

/*
 *  author : Sandhya
 */
import java.util.List;

import com.bridgelabz.fundoonotes.dto.DtoData;
import com.bridgelabz.fundoonotes.dto.LoginInfo;
import com.bridgelabz.fundoonotes.dto.PasswordUpdate;
import com.bridgelabz.fundoonotes.model.UserInformation;

public interface Services {
	Boolean register(DtoData information) throws Exception;

	UserInformation login(LoginInfo information);

	Boolean verify(String token);

	Boolean isUserExist(String Email);

	Boolean update(PasswordUpdate information, String token);

	List<UserInformation> getUsers();

	UserInformation getSingleUser(String token) throws Exception;
	public UserInformation getSingleUseByEmailr(String email);
}
