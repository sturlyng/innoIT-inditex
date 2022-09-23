package com.inditex.endpoint.adapter.in.rest;

import static com.inditex.endpoint.adapter.in.rest.RestConfig.DATE_PATTERN;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.endpoint.adapter.in.dto.PriceResponseDto;

import java.time.Instant;

import javax.validation.constraints.PositiveOrZero;

@RestController
@Validated
public interface PriceRestService {
	
	@GetMapping(value = "price", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PriceResponseDto> findPrice(
			@DateTimeFormat(pattern = DATE_PATTERN) Instant applicationDate,
			@PositiveOrZero Integer productId,
			@PositiveOrZero Integer brandId);

}
