package com.inditex.endpoint.adapter.out.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.endpoint.boot.config.entity.RestConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceResponseDto {

	private Integer productId;
	
	private Integer brandId;
	
	private Integer priceList;
	
	//@JsonFormat(pattern = RestConfig.DATE_PATTERN)
	private LocalDateTime startDate;
	
	//@JsonFormat(pattern = RestConfig.DATE_PATTERN)
	private LocalDateTime endDate;
	
	private Double price;
	
}
