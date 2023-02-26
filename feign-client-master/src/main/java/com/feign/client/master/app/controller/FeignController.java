package com.feign.client.master.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.feign.client.master.app.service.FeignService;

@RestController
public class FeignController {
	
	@Autowired
	FeignService feingService;

	@GetMapping("/getFeign/{msg}")
	public String getResponse(@PathVariable("msg") String msg) {
		String data=feingService.getRequestedData(msg+"return to the center");
		return data;
	}
	
}
