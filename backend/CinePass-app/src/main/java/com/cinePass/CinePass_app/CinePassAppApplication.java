package com.cinePass.CinePass_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // Habilita la auditoría
public class CinePassAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinePassAppApplication.class, args);
	}

}
