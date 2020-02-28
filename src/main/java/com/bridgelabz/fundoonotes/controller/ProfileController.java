package com.bridgelabz.fundoonotes.controller;

/*
 *  author : Sandhya
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.fundoonotes.model.ProfilePic;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.ProfilePicService;

@RestController
public class ProfileController {

	@Autowired
	private ProfilePicService service;

	/* API for add the profile */
	@PostMapping("profile/add")
	public ResponseEntity<Response> addProfile(@RequestBody MultipartFile file, String fileName,
			@RequestHeader("token") String token) {
		ProfilePic add = service.uploadFileTos3Bucket(file, fileName, token);
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("profilePic added", 200, add));
	}

	/* API for update the profilepic */
	@PutMapping("profile/update")
	public ResponseEntity<Response> update(@RequestBody MultipartFile file, String fileName, String contentType,
			@RequestHeader("token") String token) {
		ProfilePic update = service.updateProfile(file, fileName, contentType, token);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("updated successfully", 200, update));
	}

	/* API for delete the profile */
	@DeleteMapping("profile)/delete")
	public ResponseEntity<Response> deleteProfile(@RequestBody String key) {
		service.deleteobjectFromS3Bucket(key);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("deleted successfully", 200));
	}

}
