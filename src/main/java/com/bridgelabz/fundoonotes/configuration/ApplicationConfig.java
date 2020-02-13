package com.bridgelabz.fundoonotes.configuration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bridgelabz.fundoonotes.utility.MailServiceProvider;

@Configuration
public class ApplicationConfig {
@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
@Bean
public ModelMapper modelMapper() {
	return new ModelMapper();
}
	/*
	 * @Bean public MailServiceProvider mailServiceProvider() { return new
	 * MailServiceProvider(); }
	 */
	

}
