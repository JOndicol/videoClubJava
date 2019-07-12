package com.sopra.servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class VideoclubCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoclubCloudConfigServerApplication.class, args);
	}

}
