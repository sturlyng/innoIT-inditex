package com.inditex.endpoint.domain.repositories;

import java.time.Instant;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;

public interface PriceRepository {
	
	// Retrieve the Price matching with passed parameters from the persistence
	Price findPrice(Instant applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException;

}
