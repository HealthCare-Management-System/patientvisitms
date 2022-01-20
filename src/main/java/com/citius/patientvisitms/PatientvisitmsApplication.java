package com.citius.patientvisitms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PatientvisitmsApplication {

	
	@Bean
	public RestTemplate restTemplate() {
	   return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PatientvisitmsApplication.class, args);
	}

}
