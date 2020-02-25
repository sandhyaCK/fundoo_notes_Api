package com.bridgelabz.fundoonotes.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.dto.DtoData;
import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.response.MailObject;

@Component
public class MailServiceProvider {
	String email = System.getenv("email");
	String password = System.getenv("password");
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	public MailServiceProvider(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}

	public void send(MailObject mailObject) {
		try {

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(System.getenv(email));
			mailMessage.setTo(mailObject.getEmail());
			mailMessage.setSubject(mailObject.getSubject());
			mailMessage.setText(mailObject.getMessage());

			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			throw new UserException("error occured while sending mail");
		}
	}

}
