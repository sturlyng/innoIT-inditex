package com.inditex.endpoint.adapter.out.h2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.inditex.endpoint.domain.exception.ErrorCatalog;
import org.springframework.jdbc.core.JdbcTemplate;

import com.inditex.endpoint.adapter.in.mapper.PriceMapper;
import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class H2PriceRepository implements PriceRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<Price> findPrices(LocalDateTime applicationDate, Integer productId, Integer brandId) throws PriceNotFoundException {
		
		try {
			List<Map<String, Object>> filteredProperties = jdbcTemplate.queryForList(
					"select p.* from prices p  where ?1 >= p.start_date and ?1 <= p.end_date and product_id = ?2 and brand_id = ?3;",
					applicationDate, productId, brandId);
			
			return PriceMapper.toPrices(filteredProperties);
			
		}catch (NoSuchElementException e) {
			throw new PriceNotFoundException(ErrorCatalog.PRICE_NOT_FOUND.getCode(),
					ErrorCatalog.PRICE_NOT_FOUND.getMessage());
		}
	}

}
