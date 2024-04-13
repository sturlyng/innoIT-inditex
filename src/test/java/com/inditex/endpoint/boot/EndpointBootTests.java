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
	
	@SuppressWarnings("deprecation")
	@Test
	void testCase1() throws ParseException {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(1, response.getBody().getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T00:00:00"), response.getBody().getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), response.getBody().getEndDate());
		assertEquals(35.50, response.getBody().getPrice());
		
	}
	
	@Test
	void testCase2() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(2, response.getBody().getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T15:00:00"), response.getBody().getStartDate());
		assertEquals(LocalDateTime.parse("2020-06-14T18:30:00"), response.getBody().getEndDate());
		assertEquals(25.45, response.getBody().getPrice());
		
	}
	
	@Test
	void testCase3() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(1, response.getBody().getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-14T00:00:00"), response.getBody().getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), response.getBody().getEndDate());
		assertEquals(35.50, response.getBody().getPrice());
		
	}
	
	@Test
	void testCase4() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(3, response.getBody().getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-15T00:00:00"), response.getBody().getStartDate());
		assertEquals(LocalDateTime.parse("2020-06-15T11:00:00"), response.getBody().getEndDate());
		assertEquals(30.50, response.getBody().getPrice());
		
	}
	
	@Test
	void testCase5() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices/v1/price?applicationDate=2020-06-16T09:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(4, response.getBody().getPriceList());
		assertEquals(LocalDateTime.parse("2020-06-15T16:00:00"), response.getBody().getStartDate());
		assertEquals(LocalDateTime.parse("2020-12-31T23:59:59"), response.getBody().getEndDate());
		assertEquals(38.95, response.getBody().getPrice());
		
	}

}
