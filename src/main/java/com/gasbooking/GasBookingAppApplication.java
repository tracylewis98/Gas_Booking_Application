package com.gasbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gasbooking.entity.Bank;
import com.gasbooking.service.IBankService;

@SpringBootApplication
public class GasBookingAppApplication {

	public static void main(String[] args) {
	SpringApplication.run(GasBookingAppApplication.class, args);
		
		
	}

}
