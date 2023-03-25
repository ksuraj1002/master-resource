package com.feign.client.master.app.controller;

import com.master.core.dto.ErrorDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.feign.client.master.app.service.FeignService;

@RestController
public class FeignController {
	
	@Autowired
	FeignService feingService;

	@GetMapping("/getFeign/{msg}")
	@Operation(tags = "Notification Service API", summary = "Send webhook call",description = "Webhook callback for application id",operationId = "getResponse",responses = {
			@ApiResponse(responseCode = "202",description = "Accepted",content = @Content(schema = @Schema(implementation = String.class),mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "400",description = "Bad Reqeust",content = @Content(schema = @Schema(implementation = ErrorDetail.class),mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "403",description = "Forbidden",content = @Content(schema = @Schema(implementation = ErrorDetail.class),mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "500",description = "Server Error",content = @Content(schema = @Schema(implementation = ErrorDetail.class),mediaType = MediaType.APPLICATION_JSON_VALUE))})
	public String getResponse(@PathVariable("msg") String msg) {
		String data=feingService.getRequestedData(msg);
		return data;
	}
	
}
