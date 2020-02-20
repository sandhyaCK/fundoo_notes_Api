package com.bridgelabz.fundoonotes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class democtrl {

	public ResponseEntity<?> login(@RequestParam("userName")String uname,@RequestParam("pwd") Stringpassword){
		
	}
}
