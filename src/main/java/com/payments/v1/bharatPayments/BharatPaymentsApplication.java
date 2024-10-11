package com.payments.v1.bharatPayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableJpaRepositories
@CrossOrigin
public class BharatPaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BharatPaymentsApplication.class, args);
	}

}
