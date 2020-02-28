package com.bridgelabz.fundoonotes;

/*
 *  author : Sandhya
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication(exclude={SecurityAutoConfiguration.class})

public class FundoonotesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundoonotesApiApplication.class, args);
		System.out.println("$$$$$");
	}

}

