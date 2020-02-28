package com.bridgelabz.fundoonotes.repository;

/*
 *  author : Sandhya
 */

import java.util.List;
import com.bridgelabz.fundoonotes.dto.PasswordUpdate;
import com.bridgelabz.fundoonotes.model.UserInformation;

public interface UserRepository {
UserInformation save(UserInformation information);
UserInformation findUserById(Long id);
UserInformation getUser(String Email);
boolean update(PasswordUpdate information ,Long id);
//boolean verify(long id);
List<UserInformation> getUsers();
boolean verify(Long id);



}
