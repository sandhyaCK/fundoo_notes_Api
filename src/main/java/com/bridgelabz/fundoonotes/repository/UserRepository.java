package com.bridgelabz.fundoonotes.repository;

import java.util.List;

import com.bridgelabz.fundoonotes.dto.PasswordUpdate;
import com.bridgelabz.fundoonotes.model.UserInformation;

public interface UserRepository {
UserInformation save(UserInformation information);
UserInformation findUserById(long id);
UserInformation getUser(String Email);
boolean update(PasswordUpdate information ,long id);
boolean verify(long id);
List<UserInformation> getUsers();


}
