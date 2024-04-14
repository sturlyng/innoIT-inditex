package com.inditex.endpoint.adapter.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceResponseDto {

	private Integer productId;
	
	private Integer brandId;
	
	private Integer priceList;

	private LocalDateTime startDate;

	private LocalDateTime endDate;
	
	private Double price;
	
}
