package com.inditex.endpoint.adapter.in.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.endpoint.boot.config.entity.RestConfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceResponseDto {

	private Integer productId;
	
	private Integer brandId;
	
	private Integer priceList;
	
	@JsonFormat(pattern = RestConfig.DATE_PATTERN)
	private Date startDate;
	
	@JsonFormat(pattern = RestConfig.DATE_PATTERN)
	private Date endDate;
	
	private Double price;
	
}
