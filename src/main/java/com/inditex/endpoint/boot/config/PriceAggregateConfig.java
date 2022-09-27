package com.inditex.endpoint.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.endpoint.domain.aggregates.DefaultPriceAggregate;
import com.inditex.endpoint.domain.aggregates.PriceAggregate;
import com.inditex.endpoint.domain.repositories.PriceRepository;

@Configuration
public class PriceAggregateConfig {

	@Bean
	public PriceAggregate priceAggregate(PriceRepository priceRepository) {
		return new DefaultPriceAggregate(priceRepository);
	}
	
}
