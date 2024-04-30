package com.inditex.endpoint.adapter.out.mapper;

import com.inditex.endpoint.adapter.out.dto.PriceResponseDto;
import com.inditex.endpoint.domain.model.Price;

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
