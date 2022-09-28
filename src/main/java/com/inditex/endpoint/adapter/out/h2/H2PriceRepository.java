package com.inditex.endpoint.adapter.out.h2;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.jdbc.core.JdbcTemplate;

import com.inditex.endpoint.adapter.in.mapper.PriceMapper;
import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class H2PriceRepository implements PriceRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public Price findPrice(Date applicationDate, Integer productId, Integer brandId) throws PriceNotFoundException {
		
		/*Price result = Price.builder().id(1).brandId(1).productId(1)
				.priority(1).price(1.0).priceList(1).startDate(new java.util.Date()).endDate(new java.util.Date()).build();*/
		/*List<Price> filteredPrices = jdbcTemplate.queryForList(
				"select p.* from prices p  where ?1 >= p.start_date and ?1 <= p.end_date and product_id = ?2 and brand_id = ?3;",
				Price.class, applicationDate, productId, brandId);*/
		List<Map<String, Object>> filteredProperties = jdbcTemplate.queryForList(
				"select p.* from prices p  where ?1 >= p.start_date and ?1 <= p.end_date and product_id = ?2 and brand_id = ?3;",
				applicationDate, productId, brandId);
		List<Price> filteredPrices = PriceMapper.toPrices(filteredProperties);
		
		Price result = filteredPrices.stream()
				.max(Comparator.comparing(Price::getPriceList))
				.orElseThrow(NoSuchElementException::new);
				
		if (null != result) {
			return result;
		} else {
			throw new PriceNotFoundException("Price not found with these parameters");
		}
	}

}
