package com.inditex.endpoint.adapter.in.rest;

import com.inditex.endpoint.BaseIntegratedTest;
import com.inditex.endpoint.adapter.out.dto.PriceResponseDto;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PriceRestControllerIT extends BaseIntegratedTest {

	private static final String PRICE_RELATIVE_PATH = "/prices/v1/price";
	private final Integer productId = 35455;
	private final Integer brandId = 1;

	@Test
	void testOKCase1() {

		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 10, 00, 00);
		String urlWithParameters = composeUrlPriceWithParameters(applicationDate, productId, brandId);

		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(urlWithParameters, PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(1, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T00:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), responseBody.getEndDate());
		assertEquals(35.50, responseBody.getPrice());

	}

	@Test
	void testOKCase2() {

		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 16, 00, 00);
		String urlWithParameters = composeUrlPriceWithParameters(applicationDate, productId, brandId);

		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(urlWithParameters, PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(2, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T15:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-06-14T18:30:00"), responseBody.getEndDate());
		assertEquals(25.45, responseBody.getPrice());

	}

	@Test
	void testOKCase3() {

		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 21, 00, 00);
		String urlWithParameters = composeUrlPriceWithParameters(applicationDate, productId, brandId);

		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(urlWithParameters, PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(1, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T00:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), responseBody.getEndDate());
		assertEquals(35.50, responseBody.getPrice());

	}

	@Test
	void testOKCase4() {

		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 15, 10, 00, 00);
		String urlWithParameters = composeUrlPriceWithParameters(applicationDate, productId, brandId);

		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(urlWithParameters, PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(3, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-15T00:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-06-15T11:00:00"), responseBody.getEndDate());
		assertEquals(30.50, responseBody.getPrice());

	}

	@Test
	void testOKCase5() {

		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 16, 9, 00, 00);
		String urlWithParameters = composeUrlPriceWithParameters(applicationDate, productId, brandId);

		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(urlWithParameters, PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(4, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-15T16:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), responseBody.getEndDate());
		assertEquals(38.95, responseBody.getPrice());

	}

	@Test
	void testOKCase6() {

		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 15, 00, 00);
		String urlWithParameters = composeUrlPriceWithParameters(applicationDate, productId, brandId);

		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(urlWithParameters, PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(2, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T15:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-06-14T18:30:00"), responseBody.getEndDate());
		assertEquals(25.45, responseBody.getPrice());

	}

	@Test
	void testOKCase7() {

		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 14, 59, 59);
		String urlWithParameters = composeUrlPriceWithParameters(applicationDate, productId, brandId);

		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(urlWithParameters, PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(1, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T00:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), responseBody.getEndDate());
		assertEquals(35.50, responseBody.getPrice());

	}

	@Test
	void testOKCase8() {

		LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 15, 00, 01);
		String urlWithParameters = composeUrlPriceWithParameters(applicationDate, productId, brandId);

		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(urlWithParameters, PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(2, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T15:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-06-14T18:30:00"), responseBody.getEndDate());
		assertEquals(25.45, responseBody.getPrice());

	}

	@Test
	@DisplayName("If price is not found in DB, a PriceNotFoundException is raised with 404 status code")
	void testNOKWhenPriceIsNotFound() throws Exception {
		// Simula una solicitud al punto final con parámetros que causarán una PriceNotFoundException
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/prices/v1/price")
						.param("applicationDate", LocalDateTime.now().toString())
						.param("productId", "1")
						.param("brandId", "1"))
				.andExpect(status().isNotFound())
				.andExpect(content().string("Price not found with these parameters"))
				.andReturn();

		assertTrue(result.getResolvedException() instanceof PriceNotFoundException);
	}

	private String composeUrlPriceWithParameters (LocalDateTime applicationDate, Integer productId, Integer brandId) {
		return getServiceUrlFor(PRICE_RELATIVE_PATH)
				+ String.format("?applicationDate=%s&productId=%s&brandId=%s", applicationDate, productId, brandId);
	}

}
