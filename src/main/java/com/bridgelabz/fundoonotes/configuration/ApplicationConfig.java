package com.bridgelabz.fundoonotes.configuration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	
	/* @Bean 
	 public LabelData labelData() { 
		 return new LabelData();
	   }
	 @Bean
	 public UserInformation userData() {
		 return new UserInformation();
	 }
	@Bean
	public NoteData noteData() {
		return new NoteData();
	}
*/
}
