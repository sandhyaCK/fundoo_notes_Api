package com.bridgelabz.fundoonotes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bridgelabz.fundoonotes.utility.MailServiceProvider;


@Configuration
public class SpringMailConfiguration {
	
	@Bean
	public MailServiceProvider getSpringmail() {
		return new MailServiceProvider();

	}
}