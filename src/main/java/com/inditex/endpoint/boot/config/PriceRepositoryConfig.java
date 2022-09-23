package com.inditex.endpoint.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.endpoint.adapter.out.h2.H2PriceRepository;
import com.inditex.endpoint.domain.repositories.PriceRepository;

@Configuration
public class PriceRepositoryConfig {

	@Bean
	public PriceRepository priceRepository() {
		return new H2PriceRepository();
	}
	
}
