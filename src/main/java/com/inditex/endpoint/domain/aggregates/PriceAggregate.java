package com.inditex.endpoint.domain.aggregates;

import java.time.Instant;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;

public interface PriceAggregate {
	
	// Retrieve the Price matching with passed parameters
	Price findPrice(Instant applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException;

}
