package com.inditex.endpoint.adapter.in.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	public static List<Price> toPrices(List<Map<String, Object>> list) {
		
		return list.stream().map(properties -> Price.builder()
				.id((Integer) properties.get("id"))
				.productId((Integer) properties.get("product_id"))
				.brandId((Integer) properties.get("brand_id"))
				.priceList((Integer) properties.get("price_list"))
				.startDate((Date) properties.get("start_date"))
				.endDate((Date) properties.get("end_date"))
				.price((Double) properties.get("price"))
				.priority((Integer) properties.get("priority"))
				.curr((String) properties.get("curr"))
				.build()).collect(Collectors.toList());
	}

}
