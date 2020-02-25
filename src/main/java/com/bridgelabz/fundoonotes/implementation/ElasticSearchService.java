package com.bridgelabz.fundoonotes.implementation;

import java.util.List;

import com.bridgelabz.fundoonotes.model.UserInformation;

public interface ElasticSearchService {
	public UserInformation save(UserInformation information);
	UserInformation findUserById(Long id);
	UserInformation getUser(String Email);
	List<UserInformation> getUsers();
	boolean verify(Long id);
	void Delete(UserInformation information);
}
