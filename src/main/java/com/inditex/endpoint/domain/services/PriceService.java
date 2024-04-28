package com.inditex.endpoint.domain.services;

import java.time.Instant;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {
	
	// Retrieve the Price matching with passed parameters
	Price findPrice(Instant applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException;

}
