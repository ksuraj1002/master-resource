package com.feign.client.master.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignClientMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientMasterApplication.class, args);
	}

}
