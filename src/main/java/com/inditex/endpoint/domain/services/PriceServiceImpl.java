package com.inditex.endpoint.domain.services;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.ErrorCatalog;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {
	
	private final PriceRepository priceRepository;

	@Override
	public Price findPrice(LocalDateTime applicationDate, Integer productId, Integer brandId)
			throws PriceNotFoundException {
		List<Price>  prices = priceRepository.findPrices(applicationDate, productId, brandId);

		return prices.stream()
				.max(Comparator.comparing(Price::getPriority))
				.orElseThrow(() -> new PriceNotFoundException(ErrorCatalog.PRICE_NOT_FOUND.getCode(),
						ErrorCatalog.PRICE_NOT_FOUND.getMessage()));

	}

}
