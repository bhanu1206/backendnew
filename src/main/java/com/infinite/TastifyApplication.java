package com.infinite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class}) 
public class TastifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TastifyApplication.class, args);
	}

}
