package com.feign.client.master.app.feign;

import java.time.LocalDateTime;


public class ErrorDetail {

	private String message;
	private String details;
	private LocalDateTime timestamp;
	
	public ErrorDetail(String message, String details, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	

}
