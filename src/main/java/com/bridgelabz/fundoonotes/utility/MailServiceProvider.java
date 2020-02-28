package com.bridgelabz.fundoonotes.utility;

/*
 *  author : Sandhya
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.dto.DtoData;
import com.bridgelabz.fundoonotes.exception.UserException;
import com.bridgelabz.fundoonotes.response.MailObject;

//@Component
public class MailServiceProvider {
//	String email = System.getenv("email");
//	String password = System.getenv("password");
//
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	@Autowired
//	public MailServiceProvider(JavaMailSender javaMailSender) {
//
//		this.javaMailSender = javaMailSender;
//	}

	/* Method to send a mail for registered User */
	
//	public void send(String emailid,String jwt) {
//		try {
//
//			SimpleMailMessage mailMessage = new SimpleMailMessage();
//			mailMessage.setFrom(email);
//			mailMessage.setTo(emailid);
//			mailMessage.setSubject(jwt);
//			//mailMessage.setText(mailObject.getMessage());

//			javaMailSender.send(mailMessage);
//		} catch (Exception e) {
//			throw new UserException("error occured while sending mail");
//		}
//	}
	
	
	@Autowired
	JavaMailSender javaMailSender;

	public void sendMail(String email, String response) {
		try {
			SimpleMailMessage simpleMsg = new SimpleMailMessage();
			simpleMsg.setTo(email);
			simpleMsg.setSubject("Verify mail");
			simpleMsg.setText(response);
			javaMailSender.send(simpleMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
