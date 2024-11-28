package com.tickets.TicketsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TicketsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsAppApplication.class, args);
	}

}
