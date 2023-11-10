package com.mywellbeing.psychology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class PsychologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsychologyApplication.class, args);
	}

}
