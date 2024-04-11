package com.inditex.endpoint.adapter.out.mapper;

import com.inditex.endpoint.adapter.out.dto.PriceResponseDto;
import com.inditex.endpoint.domain.entities.Price;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceMapper {
	
	public static PriceResponseDto priceToPriceResponseDto(Price price) {
		
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
