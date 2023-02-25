package com.feign.client.master.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feign.client.master.app.feign.FeinServiceProxy;

@Service
public class FeignService {
	
	@Autowired FeinServiceProxy feingSerivceProx;

	public String getRequestedData(String msg) {
		return feingSerivceProx.getRequestedData(msg);
	}

}
