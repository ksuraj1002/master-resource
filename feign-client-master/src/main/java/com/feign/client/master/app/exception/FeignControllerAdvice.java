package com.feign.client.master.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.master.core.dto.ErrorDetail;

import feign.RetryableException;

@RestControllerAdvice
public class FeignControllerAdvice {

	@ExceptionHandler({ DuplicateFoundException.class })
	public ResponseEntity<Object> returnDuplicateFoundException(DuplicateFoundException ex, WebRequest webRequest) {
		ErrorDetail error = new ErrorDetail(ex.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

	@ExceptionHandler({ RetryableException.class })
	public ResponseEntity<Object> returnRuntimeException(RetryableException ex, WebRequest webRequest) {
		ErrorDetail error = new ErrorDetail(ex.getMessage(), webRequest.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
