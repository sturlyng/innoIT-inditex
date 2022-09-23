package com.inditex.endpoint.boot.config;

import org.springframework.context.annotation.Configuration;

import com.inditex.endpoint.domain.aggregates.DefaultPriceAggregate;
import com.inditex.endpoint.domain.repositories.PriceRepository;

@Configuration
public class PriceAggregateConfig {

	public PriceAggregateConfig priceAggregateConfig(PriceRepository priceRepository) {
		return new DefaultPriceAggregate(priceRepository);
	}
	
}
