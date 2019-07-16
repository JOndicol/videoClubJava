package com.sopra.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestTemplateLoadBalancedVcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateLoadBalancedVcApplication.class, args);
	}

}
