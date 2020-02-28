package com.bridgelabz.fundoonotes.service;

import java.io.IOException;
import java.util.Map;

import com.bridgelabz.fundoonotes.model.NoteData;

/*
 *  author : Sandhya
 */

public interface ElasticSearchService {


	String createData(NoteData notes);
	Map<String,Object> searchById(String id);
	Map<String, Object> updateById(String id,NoteData notes) throws IOException;
	void deleteById(String id);

}
