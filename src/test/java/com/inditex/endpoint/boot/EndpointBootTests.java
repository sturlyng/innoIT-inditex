package com.inditex.endpoint.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDateTime;

import com.inditex.endpoint.adapter.out.dto.PriceResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EndpointBoot.class)
public class EndpointBootTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	protected TestRestTemplate restTemplate;

	@Test
	void testCase1() throws ParseException {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);

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
	void testCase2() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);

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
	void testCase3() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);

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
	void testCase4() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);

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
	void testCase5() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-16T09:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);

		PriceResponseDto responseBody = response.getBody();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, responseBody.getProductId());
		assertEquals(1, responseBody.getBrandId());
		assertEquals(4, responseBody.getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-15T16:00:00"), responseBody.getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), responseBody.getEndDate());
		assertEquals(38.95, responseBody.getPrice());
		
	}

}
