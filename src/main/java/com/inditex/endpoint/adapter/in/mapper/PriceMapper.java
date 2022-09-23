package com.inditex.endpoint.adapter.in.mapper;

import java.time.Instant;

import com.inditex.endpoint.adapter.in.dto.PriceResponseDto;
import com.inditex.endpoint.domain.entities.Price;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PriceMapper {
	
	public static PriceResponseDto toPriceResponseDto(Price price) {
		return PriceResponseDto.builder()
				.productId(price.getProductId())
				.brandId(price.getBrandId())
				.priceList(price.getPriceList())
				.startDate(price.getStartDate())
				.endDate(price.getEndDate())
				.price(price.getPrice())
				.build();
	}

}
