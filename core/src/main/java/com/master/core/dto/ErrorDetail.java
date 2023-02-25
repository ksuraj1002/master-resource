package com.master.core.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
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
	
	

}
