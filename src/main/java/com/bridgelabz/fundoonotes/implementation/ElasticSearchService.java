
package com.bridgelabz.fundoonotes.implementation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;

public interface ElasticSearchService {

	String createNote(NoteData note);

	List<NoteData> searchByTitle(String title);

}
