package com.sopra.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class VideoclubCloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoclubCloudEurekaApplication.class, args);
	}

}
