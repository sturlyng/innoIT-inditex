package com.inditex.endpoint.application.services;

import java.time.Instant;

import com.inditex.endpoint.application.port.PriceService;
import com.inditex.endpoint.domain.model.Price;
import com.inditex.endpoint.domain.exception.ErrorCatalog;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.application.port.PriceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	@Cacheable("findPrice")
	public Price findPrice(Instant applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException {
		return priceRepository.findPrice(applicationDate, productId, brandId)
				.orElseThrow(() -> new PriceNotFoundException(ErrorCatalog.PRICE_NOT_FOUND.getCode(),
						ErrorCatalog.PRICE_NOT_FOUND.getMessage()));

	}

}
