package com.bridgelabz.fundoonotes.implementation;

/*
 *  author : Sandhya
 */

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.configuration.RabbitMQSender;
import com.bridgelabz.fundoonotes.dto.DtoData;
import com.bridgelabz.fundoonotes.dto.LoginInfo;
import com.bridgelabz.fundoonotes.dto.PasswordUpdate;
import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.model.UserInformation;
//import com.bridgelabz.fundoonotes.repository.ElasticSearchRepo;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.response.MailObject;
import com.bridgelabz.fundoonotes.response.MailResponse;
import com.bridgelabz.fundoonotes.service.Services;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
import com.bridgelabz.fundoonotes.utility.MailServiceProvider;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
	@Autowired
	private MailServiceProvider mail;
	
	@Autowired
	private JavaMailSender javaMailSender;


 @Autowired 
 private RabbitMQSender sender;

	/*
	 * @Autowired private ElasticSearchRepo elasticrepo;
	 */
	/*
	 * @Autowired public void setElasticSearchRepo(ElasticSearchRepo repo) {
	 * this.elasticrepo = repo; }
	 */
 
	/* Method for user registration */
	@Transactional
	@Override
	public Boolean register(DtoData information) {
		System.out.println("######");
		System.out.println("######");
		UserInformation user = repository.getUser(information.getEmail());
		if (user == null) {
			userInformation = modelMapper.map(information, UserInformation.class);
			userInformation.setDateTime(LocalDateTime.now());
			String epassword = encryption.encode(information.getPassword());
			userInformation.setPassword(epassword);//
			userInformation.setIsVerified(0);
		    repository.save(userInformation);
			// elasticrepo.save(userInformation);
			String mailResponse =response.fromMessage("http://localhost:8080 verify",
					generate.jwtToken(userInformation.getUserId()));
			System.out.println("#----");
			mailObject.setEmail(information.getEmail());
			mailObject.setMessage(mailResponse);
			//mailObject.setSubject("verified");
			mail.sendMail(information.getEmail(),mailResponse);
			 
			//sender.send(mailObject);
			System.out.println("######");
			System.out.println(generate.jwtToken(userInformation.getUserId()));
		//	repository.save(userInformation);
			return true;
		}
		throw new UserException("user already exist");

	}
	
	
	/* Method for user login */

	@Transactional
	@Override
	public UserInformation login(LoginInfo information) {
		UserInformation user = repository.getUser(information.getEmail());
		// UserInformation user=elasticrepo.findUser(information.getEmail());
		if (user != null) {
			if ((user.getIsVerified() == 1) && (encryption.matches(information.getPassword(), user.getPassword()))) {
				System.out.println(generate.jwtToken(user.getUserId()));
				return user;
			}
		}
		return null;
	}

	public String generateToken(Long id) {
		return generate.jwtToken(id);

	}
	/* Method for verifying the user */

	@Transactional
	@Override
	public Boolean verify(String token) {
		System.out.println("id is in verification" + (Long) generate.parseJWT(token));
		Long id = (Long) generate.parseJWT(token);
		repository.verify(id);
		return true;
	}
	/* Method to check whether the user is exist or not */

	@Transactional
	@Override
	public Boolean isUserExist(String email) {
		try {
			UserInformation user = repository.getUser(email);
			if (user.getIsVerified() == 1) {
				String mailResposne = response.fromMessage("http://localhost:8080/verify",
						generate.jwtToken(user.getUserId()));
				mailObject.setEmail(user.getEmail());
				mailObject.setSubject("verification");
				mailObject.setMessage(mailResposne);
				 //mail.send(mailObject);
				//sender.send(mailObject);
				repository.save(user);
				// elasticrepo.save(user);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new UserException("User doesn't exist with this email id");
		}

	}
	/* Method for updating the user information */

	@Transactional
	@Override
	public Boolean update(PasswordUpdate information, String token) {
		try {
			Long id = null;
			id = (Long) generate.parseJWT(token);
			String epassword = encryption.encode(information.getConfirmPassword());
			String epassword1 = encryption.encode(information.getNewPassword());
			if (epassword == epassword1) {
				information.setConfirmPassword(epassword);
			}
			return repository.update(information, id);
		} catch (Exception e) {
			throw new UserException("Invalid data ");
		}

	}
	/* Method for list out all the userIformation */

	@Transactional
	@Override
	public List<UserInformation> getUsers() {
		List<UserInformation> users = repository.getUsers();
		UserInformation user = users.get(0);
		return users;
		// return (List<UserInformation>) elasticrepo.findAll();
	}

	/* Method to get the single userInformation */
	@Transactional
	@Override
	public UserInformation getSingleUser(String token) {
		try {
			Long id = (Long) generate.parseJWT(token);

			UserInformation user = repository.findUserById(id);

			// UserInformation user=elasticrepo.findUserById(id);

			return user;
		} catch (Exception e) {
			throw new UserException("User doesn't exist ");
		}
	}
}
