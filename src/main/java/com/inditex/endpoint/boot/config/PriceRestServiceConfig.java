package com.inditex.endpoint.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.endpoint.adapter.in.rest.PriceRestControllerImpl;
import com.inditex.endpoint.domain.aggregates.PriceService;

@Configuration
public class PriceRestServiceConfig {
	
	@Bean
	public PriceRestControllerImpl priceRestServiceImpl(final PriceService priceService) {
		return new PriceRestControllerImpl(priceService);
	}

}
