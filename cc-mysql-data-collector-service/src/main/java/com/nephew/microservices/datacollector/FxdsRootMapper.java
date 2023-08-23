package com.nephew.microservices.datacollector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FxdsRootMapper {

	private ObjectMapper objectMapper;
	private FxdsRoot responseRoot;

	public FxdsRootMapper() {
		super();
		this.objectMapper = new ObjectMapper();
		this.responseRoot = new FxdsRoot();
	}

	public void readJson(String jsonResponse) {
		try {
			FxdsRoot root = objectMapper.readValue(jsonResponse, FxdsRoot.class);
			if (root != null) {
				responseRoot.getResponse().add(root.getResponse().get(0));
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FxdsRoot getResponseRoot() {
		return responseRoot;
	}

}
