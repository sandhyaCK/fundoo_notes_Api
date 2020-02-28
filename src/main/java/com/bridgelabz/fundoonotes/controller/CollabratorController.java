package com.bridgelabz.fundoonotes.controller;

/*
 *  author : Sandhya
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.response.Response;
import com.bridgelabz.fundoonotes.service.CollabratorService;

@RestController
public class CollabratorController {
	@Autowired
	private CollabratorService service;
	/* API for adding the collabrator */

	@PostMapping("Collabrate/add")
	public ResponseEntity<Response> addCollabrator(@RequestParam("NoteId") Long NoteId,
			@RequestParam("email") String email, @RequestHeader("token") String token) {
		NoteData note = service.addCollabrator(NoteId, token, email);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Collabrator added", 200, note));
	}
	/* API to get all the collabrators */

	@GetMapping("Collabrate/getAllCollabrator")
	public ResponseEntity<Response> getAllCollabrator(@RequestHeader("token") String token) {
		List<NoteData> user = service.getAllCollabrator(token);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(new Response("Listed all collabrator information", 200, user));
	}

	/* API for delete the collabrator */
	@DeleteMapping("collabrate/deleteCollabrator")
	public ResponseEntity<Response> deleteCollabrator(@RequestParam("NoteId") Long NoteId,
			@RequestParam("email") String email, @RequestHeader("token") String token) {
		NoteData note = service.deleteCollabrator(NoteId, token, email);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Collabrator removed", 200,note));
	}
}
