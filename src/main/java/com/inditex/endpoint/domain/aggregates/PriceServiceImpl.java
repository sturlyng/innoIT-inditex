package com.inditex.endpoint.domain.aggregates;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import com.inditex.endpoint.domain.entities.Price;
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

		Price result = prices.stream()
				.max(Comparator.comparing(Price::getPriceList))
				.orElseThrow(NoSuchElementException::new);

		if (null != result) {
			return result;
		} else {
			throw new PriceNotFoundException("Price not found with these parameters");
		}
	}

}
