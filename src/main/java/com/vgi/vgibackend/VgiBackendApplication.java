package com.vgi.vgibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vgi.vgibackend.**")
public class VgiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VgiBackendApplication.class, args);
	}

}
