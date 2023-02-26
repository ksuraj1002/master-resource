package com.feign.client.child.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.feign.client.child.app.exception.DuplicateFoundException;

@RestController
public class RequestHandler {
	
	@GetMapping("/getbychild/{msg}")
	public String getResponse(@PathVariable("msg") String msg){
		if(msg.equalsIgnoreCase("msg")) {
			throw new DuplicateFoundException("yo ta duplicate pryo");
		}
		return "return successfbylly by suraj----ojik greate hotstart ";
	}
}
