package com.bridgelabz.fundoonotes.implementation;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.dto.DtoData;
import com.bridgelabz.fundoonotes.dto.LoginInfo;
import com.bridgelabz.fundoonotes.dto.PasswordUpdate;
import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.response.MailObject;
import com.bridgelabz.fundoonotes.response.MailResponse;
import com.bridgelabz.fundoonotes.service.Services;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
import com.bridgelabz.fundoonotes.utility.MailServiceProvider;

@Service
public class ServiceImpl implements Services {
	private UserInformation userInformation = new UserInformation();
	@Autowired
	private JwtGenerator generate;
	@Autowired
	private BCryptPasswordEncoder encryption;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private MailResponse response;
	@Autowired
	private MailObject mailObject;
	@Autowired
	private UserRepository repository;
//@Autowired
private MailServiceProvider mail;

	@Transactional
	@Override
	public Boolean register(DtoData information) {

		UserInformation user = repository.getUser(information.getEmaill());
		if (user == null) {
			userInformation = modelMapper.map(information, UserInformation.class);
			userInformation.setDateTime(LocalDateTime.now());
			String epassword = encryption.encode(information.getPassword());
			userInformation.setPassword(epassword);
			userInformation.setIsVerified(false);
			String mailResponse = response.fromMessage("http:/localhost:8080/verify",
					generate.jwtToken(userInformation.getUserId()));
			mailObject.setEmail(information.getEmaill());
			mailObject.setMessage(mailResponse);
			mailObject.setSubject("verified");
			MailServiceProvider.sendEmail(mailObject.getEmail(), mailObject.getSubject(), mailObject.getMessage());

			return true;
		}
		throw new UserException("user already exist");

	}

	@Transactional
	@Override
	public UserInformation login(LoginInfo information) {
		UserInformation user = repository.getUser(information.getUserName());
		if (user != null) {
			if ((user.getIsVerified() == true) && (encryption.matches(information.getPassword(), user.getPassword()))) {
				System.out.println(generate.jwtToken(user.getUserId()));
				return user;
			} else {
				String mailResponse = response.fromMessage("http://localhost:8080/verify",
						generate.jwtToken(user.getUserId()));
				MailServiceProvider.sendEmail(information.getUserName(), "verification", mailResponse);
				return null;

			}

		}
		return null;
	}

	public String generateToken(long id) {
		return generate.jwtToken(id);

	}

	@Transactional
	@Override
	public Boolean verify(String token) {
		System.out.println("id is in verification" + (Long) generate.parseJWT(token));
		Long id = (long) generate.parseJWT(token);
		repository.verify(id);
		return true;
	}

	@Transactional
	@Override
	public Boolean isUserExist(String Email) {
		try {
			UserInformation user = repository.getUser(Email);
			if (user.getIsVerified() == true) {
				String mailResposne = response.fromMessage("http://localhost:8080/verify",
						generate.jwtToken(user.getUserId()));
				MailServiceProvider.sendEmail(user.getEmail(), "verification", mailResposne);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new UserException("User doesn't exist with this email id");
		}

	}

	@Transactional
	@Override
	public Boolean update(PasswordUpdate information, String token) {
		try {
			Long id = null;
			id = (long) generate.parseJWT(token);
			String epassword = encryption.encode(information.getConfirmPassword());
			information.setConfirmPassword(epassword);
			return repository.update(information, id);
		} catch (Exception e) {
			throw new UserException("Invalid data ");
		}

	}

	@Transactional
	@Override
	public List<UserInformation> getUsers() {
		List<UserInformation> users = repository.getUsers();
		UserInformation user = users.get(0);

		return users;
	}

	@Transactional
	@Override
	public UserInformation getSingleUser(String token) {
		try {
			Long id = (long) generate.parseJWT(token);

			UserInformation user = repository.findUserById(id);
			return user;
		} catch (Exception e) {
			throw new UserException("User doesn't exist ");
		}
	}
}
