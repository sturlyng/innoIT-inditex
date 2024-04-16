package com.inditex.endpoint.adapter.in.rest;

import java.time.LocalDateTime;

import com.inditex.endpoint.adapter.out.dto.PriceResponseDto;
import com.inditex.endpoint.adapter.out.mapper.PriceMapper;
import jakarta.validation.constraints.PositiveOrZero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.inditex.endpoint.domain.aggregates.PriceService;
import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prices/v1")
@AllArgsConstructor
public class PriceRestController {

	private static final Logger LOG = LoggerFactory.getLogger(PriceRestController.class);

	private final PriceService priceService;

	@GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PriceResponseDto> findPrice(
			@RequestParam LocalDateTime applicationDate,
			@RequestParam @PositiveOrZero Integer productId,
			@RequestParam @PositiveOrZero Integer brandId) throws PriceNotFoundException {

		LOG.info("Init findPrice");

		Price price = priceService.findPrice(applicationDate, productId, brandId);
		PriceResponseDto response = PriceMapper.priceToPriceResponseDto(price);
		LOG.info("findPrice completed");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
