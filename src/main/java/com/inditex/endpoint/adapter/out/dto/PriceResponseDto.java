package com.inditex.endpoint.adapter.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceResponseDto {

	private Integer productId;
	
	private Integer brandId;
	
	private Integer priceList;

	private Instant startDate;

	private Instant endDate;
	
	private Double price;
	
}
