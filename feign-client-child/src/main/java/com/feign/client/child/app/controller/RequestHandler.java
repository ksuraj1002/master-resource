package com.feign.client.child.app.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feign.client.child.app.exception.DuplicateFoundException;
import com.feign.client.child.app.service.RegistryService;

@RestController
public class RequestHandler {

	@Autowired
	RegistryService registryService;
	
	@GetMapping("/getbychild/{msg}")
	public String getResponse(@PathVariable("msg") String msg){ 
		if(msg.equalsIgnoreCase("msg")) {
			throw new DuplicateFoundException("yo ta duplicate pryo");
		}
		return "return successfbylly by suraj----ojik greate hotstart ";
	}
	
	@PostMapping("/saveRegistry")
	public ResponseEntity<?> savePincodeRegistry() throws FileNotFoundException, IOException, ParseException {
		registryService.savePincodeRegistry();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
