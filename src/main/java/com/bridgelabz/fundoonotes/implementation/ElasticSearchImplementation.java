
package com.bridgelabz.fundoonotes.implementation;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.configuration.ElasticSearchConfiguration;
import com.bridgelabz.fundoonotes.model.NoteData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ElasticSearchImplementation implements ElasticSearchService {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ElasticSearchConfiguration  config;
	private String INDEX;
	private String TYPE;
	@Override
	public String createNote(NoteData note)
	{

		Map<String, Object> dataMapper = objectMapper.convertValue(note, Map.class);
		IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, String.valueOf(note.getId())).source(dataMapper);
		IndexResponse indexResponse = null;
		try {
			indexResponse = config.client().index(indexRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return indexResponse.getResult().name();
	}

	@Override
	public List<NoteData> searchByTitle(String title) {
		SearchRequest searchRequest = new SearchRequest("fundoonotes");
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		sourceBuilder.query(QueryBuilders.matchQuery("title", title));
		searchRequest.source(sourceBuilder);
		SearchResponse searchresponse = null;
		try {
			searchresponse = config.client().search(searchRequest, RequestOptions.DEFAULT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(getSearchResult(searchresponse).toString());
		return getSearchResult(searchresponse);
	}

	private List<NoteData> getSearchResult(SearchResponse searchresponse) {
		SearchHit[] searchhits = searchresponse.getHits().getHits();
		List<NoteData> notes = new ArrayList<>();
		if (searchhits.length > 0) {
			Arrays.stream(searchhits)
					.forEach(hit -> notes.add(objectMapper.convertValue(hit.getSourceAsMap(), NoteData.class)));
		}
		return notes;
	}

}
