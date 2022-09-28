package com.inditex.endpoint.adapter.in.rest;

import static com.inditex.endpoint.boot.config.entity.RestConfig.DATE_PATTERN;

import java.util.Date;

import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.endpoint.adapter.in.dto.PriceResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Validated
@Api(tags = {"Prices"})
public interface PriceRestController {
	
	@GetMapping(value = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Finds price matching passed parameters")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation", response = PriceResponseDto.class)
			// Aqui podríamos añadir las respuestas para los posibles errores
	})
	ResponseEntity<PriceResponseDto> findPrice(
			@RequestParam @DateTimeFormat(pattern = DATE_PATTERN) Date applicationDate,
			@RequestParam @PositiveOrZero Integer productId,
			@RequestParam @PositiveOrZero Integer brandId);

}
