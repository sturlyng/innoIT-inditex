package com.inditex.endpoint.adapter.out.h2;

import java.time.Instant;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;

public class H2PriceRepository implements PriceRepository {

	@Override
	public Price findPrice(Instant applicationDate, Integer productId, Integer brandId) throws PriceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
