package com.inditex.endpoint.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.inditex.endpoint.domain.repositories")
@EntityScan(basePackages = "com.inditex.endpoint.domain.entities")
@ComponentScan(basePackages = "com.inditex.endpoint")
@EnableCaching
public class EndpointBoot {

	public static void main(String[] args) {
		SpringApplication.run(EndpointBoot.class, args);
	}

}
