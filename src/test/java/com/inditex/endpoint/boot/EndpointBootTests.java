package com.inditex.endpoint.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.endpoint.adapter.in.dto.PriceResponseDto;
import com.inditex.endpoint.boot.config.entity.RestConfig;

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
				"http://localhost:" + port + "/prices?applicationDate=2020-06-14 10:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(1, response.getBody().getPriceList());
		//assertEquals(new SimpleDateFormat(RestConfig.DATE_PATTERN).parse("2020-06-13 22:00:00"), response.getBody().getStartDate());
		assertEquals(new SimpleDateFormat(RestConfig.DATE_PATTERN).parse("2020-12-31 22:59:59").toInstant(), response.getBody().getEndDate().toInstant());
		assertEquals(35.5, response.getBody().getPrice());
		
	}
	
	@Test
	void testCase2() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices?applicationDate=2020-06-14 16:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	void testCase3() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices?applicationDate=2020-06-14 21:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	void testCase4() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices?applicationDate=2020-06-15 10:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	void testCase5() {
		
		ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/prices?applicationDate=2020-06-16 09:00:00&productId=35455&brandId=1",
				PriceResponseDto.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}

}
