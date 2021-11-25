package com.gasbooking;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.gasbooking.entity.Bank;
import com.gasbooking.service.IBankService;

@SpringBootApplication
@EnableJpaAuditing
public class GasBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasBookingAppApplication.class, args);
		System.out.println("Connected to database");
	}

}
