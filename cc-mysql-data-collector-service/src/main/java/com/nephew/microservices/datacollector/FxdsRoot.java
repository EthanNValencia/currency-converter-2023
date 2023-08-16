package com.nephew.microservices.datacollector;

import java.util.ArrayList;

public class FxdsRoot {
	
	public ArrayList<FxdsResponse> response;

	public FxdsRoot() {
		super();
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
