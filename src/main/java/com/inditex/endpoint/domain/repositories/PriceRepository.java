package com.inditex.endpoint.domain.repositories;

import java.util.Date;

import org.springframework.data.repository.Repository;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;

@org.springframework.stereotype.Repository
public interface PriceRepository extends Repository<Price, Long> {
	
	// Retrieve the Price matching with passed parameters from the persistence
	Price findPrice(Date applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException;

}
