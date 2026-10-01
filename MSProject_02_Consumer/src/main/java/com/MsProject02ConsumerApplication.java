package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProject02ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProject02ConsumerApplication.class, args);
	}

}
