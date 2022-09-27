package com.inditex.endpoint.adapter.out.h2;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class H2PriceRepository implements PriceRepository {

	@Override
	public Price findPrice(Date applicationDate, Integer productId, Integer brandId) throws PriceNotFoundException {
		
		/*Price result = Price.builder().id(1).brandId(1).productId(1)
				.priority(1).price(1.0).priceList(1).startDate(new java.util.Date()).endDate(new java.util.Date()).build();*/
		Price result = null;
				
		if (null != result) {
			return result;
		} else {
			throw new PriceNotFoundException("Price not found with these parameters");
		}
	}

}
