package com.inditex.endpoint.application.port;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inditex.endpoint.domain.model.Price;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	
	// Retrieve the Price matching with passed parameters from the persistence layer
	@Query(value = "select * from prices p  " +
			"where ?1 >= p.start_date " +
			"and ?1 <= p.end_date " +
			"and p.product_id = ?2 " +
			"and p.brand_id = ?3 " +
			"order by p.priority_order desc " +
			"limit 1", nativeQuery = true)
	Optional<Price> findPrice(Instant applicationDate, Integer productId, Integer brandId);

}
