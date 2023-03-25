package com.feign.client.master.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Digital Platform Notification Service", version = "v1.0",
								description = "This app provides REST APIs for Notification Service APIs",
								contact = @Contact(name="Bell Canada",email = "sx00@gmail.com",url = "https://krazyshayari.com")),
					servers = {@Server(url = "https://krazyshayari.com/getdata",description = "Shero-shayaria")}
		) 
public class FeignClientMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientMasterApplication.class, args);
	}

}
