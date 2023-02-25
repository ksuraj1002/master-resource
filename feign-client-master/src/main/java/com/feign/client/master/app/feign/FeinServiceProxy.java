package com.feign.client.master.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="com.feign.client.child",url = "${child.service.url}")
public interface FeinServiceProxy {

	@GetMapping("/getbychild/{msg}")
	String getRequestedData(@PathVariable("msg") String msg);

}
