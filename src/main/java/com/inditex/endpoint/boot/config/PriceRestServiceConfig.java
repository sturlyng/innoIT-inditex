package com.inditex.endpoint.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.endpoint.adapter.in.rest.PriceRestServiceImpl;
import com.inditex.endpoint.domain.aggregates.PriceAggregate;

@Configuration
public class PriceRestServiceConfig {
	
	@Bean
	public PriceRestServiceImpl priceRestServiceImpl(final PriceAggregate priceAggregate) {
		return new PriceRestServiceImpl(priceAggregate);
	}

}
