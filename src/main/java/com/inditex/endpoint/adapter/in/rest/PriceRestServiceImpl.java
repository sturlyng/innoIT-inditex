package com.inditex.endpoint.adapter.in.rest;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.inditex.endpoint.adapter.in.dto.PriceResponseDto;
import com.inditex.endpoint.adapter.in.exception.RestNotFoundException;
import com.inditex.endpoint.adapter.in.mapper.PriceMapper;
import com.inditex.endpoint.domain.aggregates.PriceAggregate;
import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceRestServiceImpl implements PriceRestService {
	
	private final PriceAggregate priceAggregate;

	@Override
	public ResponseEntity<PriceResponseDto> findPrice(Instant applicationDate, Integer productId,
			Integer brandId) {
		
		
		try {
			Price price = priceAggregate.findPrice(applicationDate, productId, brandId);
			PriceResponseDto response = PriceMapper.toPriceResponseDto(price);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (PriceNotFoundException e) {
			throw new RestNotFoundException(e.getMessage());
		}
	}

}
