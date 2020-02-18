package com.bridgelabz.fundoonotes.service;

import java.util.List;

import com.bridgelabz.fundoonotes.model.NoteData;

public interface CollabratorService {
NoteData addCollabrator(Long NoteId,String token,String email);
List<NoteData> getAllCollabrator(String token);
NoteData deleteCollabrator(Long NoteId,String token,String email);
}
