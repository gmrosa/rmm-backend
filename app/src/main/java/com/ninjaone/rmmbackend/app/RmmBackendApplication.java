package com.ninjaone.rmmbackend.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.ninjaone.rmmbackend.*")
@ComponentScan(basePackages = { "com.ninjaone.rmmbackend.*" })
@EntityScan("com.ninjaone.rmmbackend.*")
@SpringBootApplication
public class RmmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmmBackendApplication.class, args);
	}

}
