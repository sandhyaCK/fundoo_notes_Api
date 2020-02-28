
package com.bridgelabz.fundoonotes.implementation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.bridgelabz.fundoonotes.model.NoteData;
import com.bridgelabz.fundoonotes.model.UserInformation;

public interface ElasticSearchService {

	String createData(NoteData note);
	Map<String,Object> searchById(String id);
	Map<String, Object> updateById(String id,NoteData notes) throws IOException;
	void deleteById(String id);
}
