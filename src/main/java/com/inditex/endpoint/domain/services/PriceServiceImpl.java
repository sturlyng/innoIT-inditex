package com.inditex.endpoint.domain.services;

import java.time.LocalDateTime;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.ErrorCatalog;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public Price findPrice(LocalDateTime applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException {
		return priceRepository.findPrice(applicationDate, productId, brandId)
				.orElseThrow(() -> new PriceNotFoundException(ErrorCatalog.PRICE_NOT_FOUND.getCode(),
						ErrorCatalog.PRICE_NOT_FOUND.getMessage()));

	}

}
