package com.ivansoft.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class RespService {
	
	private String jsonResponse;
	private String isoRequest;
	private String isoResponse;
	

	
	public String getJsonResponse() {
		return jsonResponse;
	}

	public void setJsonResponse(String jsonResponse) {
		this.jsonResponse = jsonResponse;
	}

	public String getIsoResponse() {
		return isoResponse;
	}

	public void setIsoResponse(String isoResponse) {
		this.isoResponse = isoResponse;
	}

	public String getIsoRequest() {
		return isoRequest;
	}

	public void setIsoRequest(String isoRequest) {
		this.isoRequest = isoRequest;
	}
	
	
	
	

}
