package com.inditex.endpoint.domain.aggregates;

import java.time.Instant;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;

public class DefaultPriceAggregate implements PriceAggregate {
	
	private final PriceRepository priceRepository;

	@Override
	public Price findPrice(Instant applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException {
		return priceRepository.findPrice(applicationDate, productId, brandId);
	}

}
