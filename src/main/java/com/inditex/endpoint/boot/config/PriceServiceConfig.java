package com.inditex.endpoint.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.endpoint.domain.services.PriceServiceImpl;
import com.inditex.endpoint.domain.services.PriceService;
import com.inditex.endpoint.domain.repositories.PriceRepository;

@Configuration
public class PriceServiceConfig {

	@Bean
	public PriceService priceService(PriceRepository priceRepository) {
		return new PriceServiceImpl(priceRepository);
	}
	
}
