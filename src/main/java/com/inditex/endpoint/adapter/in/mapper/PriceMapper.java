package com.inditex.endpoint.adapter.in.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.endpoint.domain.entities.Price;

public class PriceMapper {
	
	public static List<Price> toPrices(List<Map<String, Object>> list) {
		
		return list.stream().map(properties ->
			{
				Timestamp startDate = (Timestamp) properties.get("start_date");
				Timestamp endDate = (Timestamp) properties.get("end_date");

				Price price = Price.builder()
					.id((Integer) properties.get("id"))
					.productId((Integer) properties.get("product_id"))
					.brandId((Integer) properties.get("brand_id"))
					.priceList((Integer) properties.get("price_list"))
					.startDate(startDate.toLocalDateTime())
					.endDate(endDate.toLocalDateTime())
					.price((Double) properties.get("price"))
					.priority((Integer) properties.get("priority_order"))
					.curr((String) properties.get("curr"))
					.build();
				return price;
			}).collect(Collectors.toList());
	}

}
