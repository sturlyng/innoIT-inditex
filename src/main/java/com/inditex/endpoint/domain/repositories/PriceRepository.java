package com.inditex.endpoint.domain.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;

@org.springframework.stereotype.Repository
public interface PriceRepository extends Repository<Price, Long> {
	
	// Retrieve the Price matching with passed parameters from the persistence
	@Query("select p from Price p where p.startDate >= ?1 and p.endDate <= ?1 and productId = ?2 and brandId = ?3")
	Price findPrice(Date applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException;

}
