package com.list.app.model;

import java.util.List;
import java.util.Map;

import com.list.app.entity.Scenarios;

public class Response {

	private Map<String, List<Scenarios>> response;

	public Map<String, List<Scenarios>> getResponse() {
		return response;
	}

	public void setResponse(Map<String, List<Scenarios>> response) {
		this.response = response;
	}
	
}
