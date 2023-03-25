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
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", 
								description = "Employees Information",contact = @Contact(name="Suraj",email = "sx00@gmail.com",url = "website")),
					servers = {@Server(url = "serverUrl",description = "prod server")}
		) 
public class FeignClientMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientMasterApplication.class, args);
	}

}
