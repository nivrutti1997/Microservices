package com.niv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StockPriceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceAppApplication.class, args);
	}

}
