package com.list.app.model;

import java.util.List;
import java.util.Map;

import com.list.app.entity.Description;

public class Response {

	private Map<String, List<Description>> response;

	public Map<String, List<Description>> getResponse() {
		return response;
	}

	public void setResponse(Map<String, List<Description>> response) {
		this.response = response;
	}
	
}
