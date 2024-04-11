package com.inditex.endpoint.domain.aggregates;

import java.time.LocalDateTime;
import java.util.Date;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;

public interface PriceService {
	
	// Retrieve the Price matching with passed parameters
	Price findPrice(LocalDateTime applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException;

}
