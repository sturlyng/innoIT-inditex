package com.inditex.endpoint.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.endpoint.domain.aggregates.PriceServiceImpl;
import com.inditex.endpoint.domain.aggregates.PriceService;
import com.inditex.endpoint.domain.repositories.PriceRepository;

@Configuration
public class PriceAggregateConfig {

	@Bean
	public PriceService priceAggregate(PriceRepository priceRepository) {
		return new PriceServiceImpl(priceRepository);
	}
	
}
