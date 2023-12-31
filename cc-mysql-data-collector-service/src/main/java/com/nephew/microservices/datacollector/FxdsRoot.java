package com.nephew.microservices.datacollector;

import java.util.ArrayList;

public class FxdsRoot {
	
	private ArrayList<FxdsResponse> response;

	public FxdsRoot() {
		super();
		this.response = new ArrayList<FxdsResponse>();
	}

	public FxdsRoot(ArrayList<FxdsResponse> response) {
		super();
		this.response = response;
	}

	public ArrayList<FxdsResponse> getResponse() {
		return response;
	}

	public void setResponse(ArrayList<FxdsResponse> response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "FxdsRoot [response=" + response + "]";
	}

}
